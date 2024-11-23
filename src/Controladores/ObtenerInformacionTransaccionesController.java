/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vista.ListarTransaccionesView;

import core.models.Bank;
import core.models.Transaction;

/**
 *
 * @author arang
 */
public class ObtenerInformacionTransaccionesController {

    private ListarTransaccionesView view;
    private Bank bankmodel;

    public ObtenerInformacionTransaccionesController(ListarTransaccionesView view, Bank bankmodel) {
        this.view = view;
        this.bankmodel = bankmodel;
        initController();
    }

    private void initController() {
        view.setRefrescarAction(evt -> refrescarTransaciones());
    }

    private void refrescarTransaciones() {
        view.clearTable();
        for (Transaction transaction : this.bankmodel.getTransactions()) {
            view.addRow(new Object[]{
                transaction.getType(),
                transaction.getSourceAccountId(),
                transaction.getDestinationAccountId(),
                transaction.getAmount()
            });
        }

    }

}
