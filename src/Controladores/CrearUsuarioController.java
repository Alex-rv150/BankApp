/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vista.RegistroUsuarioView;
import core.models.Bank;
import core.models.User;
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
        view.setRegistroUsuarioBotonActionListener(evt -> registrarUsuario());
    }

    private void registrarUsuario() {

        try {
            int id = Integer.parseInt(view.getIdInput());
            String firstname = view.getFirstnameInput();
            String lastname = view.getLastnameInput();
            int age = Integer.parseInt(view.getAgeInput());

            // Agregar usuario
            this.bankmodel.addUser(new User(id, firstname, lastname, age));
            view.clearFields();
            JOptionPane.showMessageDialog(view, "User registered successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error registering user: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
