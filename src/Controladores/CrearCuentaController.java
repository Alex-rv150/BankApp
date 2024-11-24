/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vista.CrearCuentaView;
import core.models.Bank;
import core.models.BasicAccount;
import core.models.User;
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
        view.setCrearCuentaAction(evt -> crearCuenta());
    }

    private void crearCuenta() {

        try {
            int userId = Integer.parseInt(view.getUserIdInput());
            double initialBalance = Double.parseDouble(view.getInitialBalanceInput());

            User selectedUser = null;
            for (User user : this.bankmodel.getUsers()) {
                if (user.getId() == userId) {
                    selectedUser = user;
                    break;
                }
            }

            if (selectedUser != null) {
                Random random = new Random();
                String accountId = String.format("%03d-%06d-%02d",
                        random.nextInt(1000), random.nextInt(1000000), random.nextInt(100));

                this.bankmodel.createAccount(new BasicAccount(accountId, selectedUser, initialBalance));
                view.clearFields();
                JOptionPane.showMessageDialog(view, "Account created successfully!");
            } else {
                throw new ValidationException("User not found");
            }
        } catch (ValidationException e) {
            JOptionPane.showMessageDialog(view, "Error creating account: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
