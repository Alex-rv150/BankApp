/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Controladores.utils.Response;
import Controladores.utils.Status;
import Vista.RegistroUsuarioView;
import core.models.Bank;
import core.models.User;
import core.validators.UserValidator;
import core.validators.ValidationException;
import javax.swing.JOptionPane;

/**
 *
 * @author arang
 */
public class CrearUsuarioController {

    private final RegistroUsuarioView view;
    private Bank bankmodel;

    public CrearUsuarioController(RegistroUsuarioView view, Bank bankmodel) {
        this.view = view;
        this.bankmodel = bankmodel;
        initController();
    }

    private void initController() {
        view.setRegistroUsuarioBotonActionListener(evt -> handleRegistrarUsuario());
    }
    
    private void handleRegistrarUsuario() {
        Response response = registrarUsuario();

        // Manejar la respuesta con un mensaje en la vista
        if (response.getStatus() == Status.OK || response.getStatus() == Status.CREATED) {
            view.clearFields();
            JOptionPane.showMessageDialog(view, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(view, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private Response registrarUsuario() {
    try {
        // Obtener datos de entrada desde la vista
        int id = Integer.parseInt(view.getIdInput());
        String firstname = view.getFirstnameInput();
        String lastname = view.getLastnameInput();
        int age = Integer.parseInt(view.getAgeInput());

        // Crear usuario
        User user = new User(id, firstname, lastname, age);

        // Validar usuario usando UserValidator
        
        Response validationResponse = UserValidator.validateUser(user, bankmodel.getUserRepository());
        
        if (validationResponse.getStatus() != Status.OK) {
            return validationResponse; // Retornar respuesta con el mensaje de error
        }

        // Si es válido, agregarlo al banco
        bankmodel.addUser(user);

        return new Response("Usuario registrado exitosamente.", Status.CREATED, user);

    } catch (NumberFormatException e) {
        return new Response("Entrada inválida. Por favor, ingrese números válidos.", Status.BAD_REQUEST);
    } catch (Exception e) {
        return new Response("Error interno del servidor.", Status.INTERNAL_SERVER_ERROR);
    }
}

    

}
