/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Controladores.utils.Response;
import Controladores.utils.Status;
import Vista.HacerTransaccionView;
import core.models.Account;
import core.models.Bank;
import core.models.TransactionFactory;
import core.validators.TransactionValidator;
import core.validators.ValidationException;
import javax.swing.JOptionPane;

/**
 *
 * @author arang
 */
public class RealizarTransaccionController {

    private HacerTransaccionView view;
    private Bank bankmodel;

    public RealizarTransaccionController(HacerTransaccionView view, Bank bankmodel) {
        this.view = view;
        this.bankmodel = bankmodel;
        initController();
    }

    private void initController() {
        view.setEjecutarAction(evt -> realizarTransaccion());
    }

    private void realizarTransaccion() {
    try {
        String tipo = view.getTipoTransaccion();
        String cuentaOrigen = view.getCuentaOrigen();
        String cuentaDestino = view.getCuentaDestino();
        double monto;

        try {
            monto = Double.parseDouble(view.getMonto());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "El monto debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Account origen = null, destino = null;
        Response response;

        switch (tipo) {
            case "Deposit" -> {
                destino = this.bankmodel.getAccounts().findById(cuentaDestino);
                response = TransactionValidator.validateDeposit(destino, monto);
                if (response.getStatus() != Status.OK) {
                    JOptionPane.showMessageDialog(view, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                this.bankmodel.processTransaction(TransactionFactory.createDeposit(destino, monto));
            }
            case "Withdraw" -> {
                origen = this.bankmodel.getAccounts().findById(cuentaOrigen);
                response = TransactionValidator.validateWithdrawal(origen, monto);
                if (response.getStatus() != Status.OK) {
                    JOptionPane.showMessageDialog(view, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                this.bankmodel.processTransaction(TransactionFactory.createWithdraw(origen, monto));
            }
            case "Transfer" -> {
                origen = this.bankmodel.getAccounts().findById(cuentaOrigen);
                destino = this.bankmodel.getAccounts().findById(cuentaDestino);
                response = TransactionValidator.validateTransfer(origen, destino, monto);
                if (response.getStatus() != Status.OK) {
                    JOptionPane.showMessageDialog(view, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                this.bankmodel.processTransaction(TransactionFactory.createTransfer(origen, destino, monto));
            }
            default -> {
                JOptionPane.showMessageDialog(view, "Tipo de transacción no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        view.clearFields();
        JOptionPane.showMessageDialog(view, "Transacción ejecutada con éxito.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(view, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }}

}
