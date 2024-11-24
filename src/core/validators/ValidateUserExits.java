/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validators;

import core.models.User;
import core.models.UserRepository;

/**
 *
 * @author arang
 */
public class ValidateUserExits {

    public static void validateUSersExits(UserRepository userRepository, User user) {
        if (userRepository.findById(user.getId()) == null) {
            throw new ValidationException("El usuario no está registrado en la plataforma.");
        }

    }

    ;

      

    public static void validateUSersNoExits(UserRepository userRepository, User user) {

        if (userRepository.findById(user.getId()) != null) {
            throw new ValidationException("El usuario ya está registrado en la plataforma.");
        }

    }

}
