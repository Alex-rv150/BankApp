/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Controladores.utils.Response;
import Controladores.utils.Status;
import Vista.ListarTransaccionesView;

import core.models.Bank;
import core.models.transactions.Transaction;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        Response response = obtenerTransacciones();

        if (response.getStatus() == Status.OK) {
            // Si la respuesta es exitosa, muestra las transacciones en la tabla
            ArrayList<Transaction> transacciones = (ArrayList<Transaction>) response.getObject();
            for (Transaction transaction : transacciones) {
                view.addRow(new Object[]{
                    transaction.getType(),
                    transaction.getSourceAccountId(),
                    transaction.getDestinationAccountId(),
                    transaction.getAmount()
                });
            }
            JOptionPane.showMessageDialog(view, response.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si ocurre un error o no hay transacciones, muestra el mensaje correspondiente
            JOptionPane.showMessageDialog(view, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     private Response obtenerTransacciones() {
        try {
            ArrayList<Transaction> transacciones = this.bankmodel.getTransactionsOrderedByDate();
            if (transacciones.isEmpty()) {
                return new Response("No se encontraron transacciones en el sistema.", Status.NO_CONTENT);
            }
            return new Response("Transacciones obtenidas exitosamente.", Status.OK, transacciones);
        } catch (Exception e) {
            return new Response("Error al obtener las transacciones: " + e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

}
