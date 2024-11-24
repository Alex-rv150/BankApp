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
public class UserValidator {

    public static void validateUser(User user, UserRepository userRepository) {
        if (user == null) {
            throw new ValidationException("El usuario no puede ser nulo.");
        }
        
        ValidateUserExits.validateUSersNoExits(userRepository, user);
            
        if (user.getId() < 0 || String.valueOf(user.getId()).length() > 9) {
            throw new ValidationException("El ID debe ser mayor o igual a 0 y tener a lo más 9 dígitos.");
        }
        if ( user.getFirstname().trim().isEmpty()) {
            throw new ValidationException("El nombre no puede estar vacío.");
        }
        if (user.getLastname().trim().isEmpty()) {
            throw new ValidationException("El apellido no puede estar vacío.");
        }
        if (user.getAge() < 18) {
            throw new ValidationException("La edad debe ser mayor o igual a 18.");
        }
    }
}