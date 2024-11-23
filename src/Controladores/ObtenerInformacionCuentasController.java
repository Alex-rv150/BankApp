/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vista.ListarCuentasView;
import core.models.Account;
import core.models.Bank;

/**
 *
 * @author arang
 */
public class ObtenerInformacionCuentasController {

    private ListarCuentasView view;
    private Bank bankmodel;

    public ObtenerInformacionCuentasController(ListarCuentasView view, Bank bankmodel) {
        this.view = view;
        this.bankmodel = bankmodel;
        initController();
    }

    private void initController() {
        view.setRefrescarAction(evt -> refrescarCuentas());
    }

    private void refrescarCuentas() {
        view.clearTable();
        for (Account account : this.bankmodel.getAccounts()) {
            view.addRow(new Object[]{
                account.getId(),
                account.getOwner().getId(),
                account.getBalance()
            });
        }
    }

}
