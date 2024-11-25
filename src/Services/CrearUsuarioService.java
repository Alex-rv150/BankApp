/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Controladores.utils.Response;
import Controladores.utils.Status;
import core.models.Bank;
import core.models.User;
import core.validators.UserValidator;

/**
 *
 * @author arang
 */
public class CrearUsuarioService {
    private final Bank bank;

    public CrearUsuarioService(Bank bank) {
        this.bank = bank;
    }

    public Response registrarUsuario(User user) {
        // Validar usuario usando UserValidator
        Response validationResponse = UserValidator.validateUser(user, bank.getUserRepository());
        if (validationResponse.getStatus() != Status.OK) {
            return validationResponse;
        }
        // Si es válido, agregarlo al banco
        bank.addUser(user);
        return new Response("Usuario registrado exitosamente.", Status.CREATED, user);
    }
}
