/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Controladores.utils.Response;
import Controladores.utils.Status;
import Vista.ListarCuentasView;
import core.models.Account;
import core.models.Bank;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        Response response = obtenerCuentas();

        if (response.getStatus() == Status.OK) {
            // Si la respuesta es exitosa, agrega las cuentas a la tabla
            ArrayList<Account> cuentas = (ArrayList<Account>) response.getObject();
            for (Account account : cuentas) {
                view.addRow(new Object[]{
                    account.getId(),
                    account.getOwner().getId(),
                    account.getBalance()
                });
            }
            JOptionPane.showMessageDialog(view, response.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si ocurre un error, muestra el mensaje correspondiente
            JOptionPane.showMessageDialog(view, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private Response obtenerCuentas() {
        try {
            ArrayList<Account> cuentas = this.bankmodel.getAccountsOrderedById();
            if (cuentas.isEmpty()) {
                return new Response("No se encontraron cuentas en el sistema.", Status.NO_CONTENT);
            }
            return new Response("Cuentas obtenidas exitosamente.", Status.OK, cuentas);
        } catch (Exception e) {
            return new Response("Error al obtener las cuentas: " + e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

}
