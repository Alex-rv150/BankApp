/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Controladores.utils.Response;
import Controladores.utils.Status;
import Vista.CrearCuentaView;
import core.models.Bank;
import core.models.BasicAccount;
import core.models.User;
import core.validators.AccountValidator;
import core.validators.ValidationException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author arang
 */
public class CrearCuentaController {

    private CrearCuentaView view;
    private Bank bankmodel;

    public CrearCuentaController(CrearCuentaView view, Bank bankmodel) {
        this.view = view;
        this.bankmodel = bankmodel;
        initController();
    }

    private void initController() {
        view.setCrearCuentaAction(evt -> handleCrearCuenta());
    }
    
    private void handleCrearCuenta() {
        Response response = crearCuenta();

        // Manejar la respuesta con un mensaje en la vista
        if (response.getStatus() == Status.OK || response.getStatus() == Status.CREATED) {
            view.clearFields();
            JOptionPane.showMessageDialog(view, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(view, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Response crearCuenta() {

         try {
            // Obtener los datos ingresados en la vista
            int userId = Integer.parseInt(view.getUserIdInput());
            double initialBalance = Double.parseDouble(view.getInitialBalanceInput());

            // Buscar al usuario en el repositorio
            User selectedUser = bankmodel.getUserRepository().findById(userId);
            if (selectedUser == null) {
                return new Response("El usuario no existe en la plataforma.", Status.NOT_FOUND);
            }

            // Generar un ID para la cuenta
            Random random = new Random();
            String accountId = String.format("%03d-%06d-%02d",
                    random.nextInt(1000), random.nextInt(1000000), random.nextInt(100));

            // Crear la cuenta
            BasicAccount newAccount = new BasicAccount(accountId, selectedUser, initialBalance);

            // Validar la cuenta utilizando el AccountValidator
            AccountValidator.validateAccount(newAccount, bankmodel.getUserRepository(), bankmodel.getAccountRepository());

            // Agregar la cuenta al repositorio
            bankmodel.createAccount(newAccount);

            return new Response("Cuenta creada exitosamente.", Status.CREATED, newAccount);

        } catch (ValidationException e) {
            return new Response("Error al crear la cuenta: " + e.getMessage(), Status.BAD_REQUEST);
        } catch (NumberFormatException e) {
            return new Response("Entrada inválida. Por favor, ingrese números válidos.", Status.BAD_REQUEST);
        } catch (Exception e) {
            return new Response("Error interno del servidor.", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    

}
