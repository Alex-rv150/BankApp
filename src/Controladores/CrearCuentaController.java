/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Controladores.utils.Response;
import Controladores.utils.Status;
import Services.AccountService;
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
    private AccountService accountService;

    public CrearCuentaController(CrearCuentaView view, AccountService accountService) {
        this.view = view;
        this.accountService = accountService;
        initController();
    }

    private void initController() {
        view.setCrearCuentaAction(evt -> handleCrearCuenta());
    }

    private void handleCrearCuenta() {
        try {
            int userId = Integer.parseInt(view.getUserIdInput());
            double initialBalance = Double.parseDouble(view.getInitialBalanceInput());

            Response response = accountService.createAccount(userId, initialBalance);

            if (response.getStatus() == Status.OK || response.getStatus() == Status.CREATED) {
                view.clearFields();
                JOptionPane.showMessageDialog(view, response.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(view, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Entrada inválida. Por favor, ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
