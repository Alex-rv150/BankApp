/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vista.HacerTransaccionView;
import core.models.Account;
import core.models.Bank;
import core.models.TransactionFactory;
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
            double monto = Double.parseDouble(view.getMonto());

            Account origen = null, destino = null;
            for (Account account : this.bankmodel.getAccounts()) {
                if (account.getId().equals(cuentaOrigen)) {
                    origen = account;
                }
                if (account.getId().equals(cuentaDestino)) {
                    destino = account;
                }
            }

            switch (tipo) {
                case "Deposit" -> {
                    if (destino != null) {
                        destino.deposit(monto);
                        this.bankmodel.processTransaction(TransactionFactory.createDeposit(destino, monto));
                    }
                }
                case "Withdraw" -> {
                    if (origen != null && origen.withdraw(monto)) {
                        this.bankmodel.processTransaction(TransactionFactory.createWithdraw(origen, monto));
                    }
                }
                case "Transfer" -> {
                    if (origen != null && destino != null ) {
                        this.bankmodel.processTransaction(TransactionFactory.createTransfer(origen, destino, monto));
                    }
                }
            }
            view.clearFields();
            JOptionPane.showMessageDialog(view, "Transaction executed successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error executing transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
