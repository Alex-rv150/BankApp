/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Controladores.utils.Response;
import Controladores.utils.Status;
import Vista.ListarUsuariosView;
import core.models.Bank;
import core.models.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        Response response = obtenerUsuarios();

        if (response.getStatus() == Status.OK) {
            // Si la respuesta es exitosa, muestra los usuarios en la tabla
            ArrayList<User> usuarios = (ArrayList<User>) response.getObject();
            for (User user : usuarios) {
                view.addRow(new Object[]{
                    user.getId(),
                    user.getFirstname() + " " + user.getLastname(),
                    user.getAge(),
                    user.getNumAccounts()
                });
            }
            JOptionPane.showMessageDialog(view, response.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Si ocurre un error o no hay usuarios, muestra el mensaje correspondiente
            JOptionPane.showMessageDialog(view, response.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private Response obtenerUsuarios() {
        try {
            ArrayList<User> usuarios = this.bankmodel.getUsersOrderedById();
            if (usuarios.isEmpty()) {
                return new Response("No se encontraron usuarios en el sistema.", Status.NO_CONTENT);
            }
            return new Response("Usuarios obtenidos exitosamente.", Status.OK, usuarios);
        } catch (Exception e) {
            return new Response("Error al obtener los usuarios: " + e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

}
