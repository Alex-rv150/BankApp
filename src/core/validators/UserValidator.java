/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validators;

import Controladores.utils.Response;
import Controladores.utils.Status;
import core.models.User;
import core.models.repository.UserRepository;

/**
 *
 * @author arang
 */
public class UserValidator {

    public static Response  validateUser(User user, UserRepository userRepository) {
        if (user == null) {
            return new Response("El usuario no puede ser nulo.", Status.BAD_REQUEST);
        }

        Response userExistsResponse = validateUserNoExists(userRepository, user);

        if (userExistsResponse.getStatus() != Status.OK) {
            return userExistsResponse; // Retorna la respuesta si la validación falla
        }

        if (user.getId() < 0 || String.valueOf(user.getId()).length() > 9) {
            return new Response("El ID debe ser mayor o igual a 0 y tener a lo más 9 dígitos.", Status.BAD_REQUEST);
        }
        if (user.getFirstname() == null || user.getFirstname().trim().isEmpty()) {
            return new Response("El nombre no puede estar vacío.", Status.BAD_REQUEST);
        }
        if (user.getLastname() == null || user.getLastname().trim().isEmpty()) {
            return new Response("El apellido no puede estar vacío.", Status.BAD_REQUEST);
        }
        if (user.getAge() < 18) {
            return new Response("La edad debe ser mayor o igual a 18.", Status.BAD_REQUEST);
        }

        return new Response("Usuario válido.", Status.OK);
    }

    public static Response validateUserExists(UserRepository userRepository, User user) {
        if (userRepository.findById(user.getId()) == null) {
            return new Response("El usuario no está registrado en la plataforma.", Status.NOT_FOUND);
        }
        return new Response("Usuario encontrado en la plataforma.", Status.OK);
    }

    public static Response validateUserNoExists(UserRepository userRepository, User user) {
        if (userRepository.findById(user.getId()) != null) {
            return new Response("El usuario ya está registrado en la plataforma.", Status.BAD_REQUEST);
        }
        return new Response("El usuario no está registrado, es válido para agregar.", Status.OK);
    }

}
