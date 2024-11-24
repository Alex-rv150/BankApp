/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vista.ListarUsuariosView;
import core.models.Bank;
import core.models.User;

/**
 *
 * @author arang
 */
public class ObtenerInformacionUsuariosController {

    private ListarUsuariosView view;
    private Bank bankmodel;

    public ObtenerInformacionUsuariosController(ListarUsuariosView view, Bank bankmodel) {
        this.view = view;
        this.bankmodel = bankmodel;
        initController();
    }

    private void initController() {
        view.setRefrescarAction(evt -> refrescarUsuarios());
    }

    private void refrescarUsuarios() {
        view.clearTable();
        for (User user : this.bankmodel.getUsersOrderedById()) {
            view.addRow(new Object[]{
                user.getId(),
                user.getFirstname() + " " + user.getLastname(),
                user.getAge(),
                user.getNumAccounts()
            });
        }

    }

}
