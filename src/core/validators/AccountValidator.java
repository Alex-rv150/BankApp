/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validators;

import Controladores.utils.Response;
import Controladores.utils.Status;
import core.models.Account;
import core.models.repository.AccountRepository;
import core.models.repository.UserRepository;
import java.util.regex.Pattern;

/**
 *
 * @author arang
 */
public class AccountValidator {

    public static Response validateAccount(Account account, UserRepository userRepository, AccountRepository accountRepository) {
        // Validar saldo
        Response balanceResponse = validarBalance(account);
        if (balanceResponse.getStatus() != Status.OK) {
            return balanceResponse;
        }

        // Validar existencia del usuario asociado a la cuenta
        Response userExistsResponse = UserValidator.validateUserExists(userRepository, account.getOwner());
        if (userExistsResponse.getStatus() != Status.OK) {
            return userExistsResponse;
        }

        // Validar formato del ID de cuenta
        Response formatResponse = validarFormato(account.getId());
        if (formatResponse.getStatus() != Status.OK) {
            return formatResponse;
        }

        // Validar que la cuenta no exista previamente
        Response noExistResponse = validarNoExistencia(account, accountRepository);
        if (noExistResponse.getStatus() != Status.OK) {
            return noExistResponse;
        }

        // Si todas las validaciones pasan, retornar respuesta exitosa
        return new Response("Validación exitosa.", Status.OK);
    }

    public static Response validarFormato(String id) {
        String regex = "\\d{3}-\\d{6}-\\d{2}";
        if (!Pattern.matches(regex, id)) {
            return new Response("El ID de la cuenta no sigue el formato requerido: XXX-XXXXXX-XX.", Status.BAD_REQUEST);
        }
        return new Response("Formato de ID válido.", Status.OK);
    }

     public static Response validarExistencia(Account account, AccountRepository accountRepository) {
        if (accountRepository.findById(account.getId()) == null) {
            return new Response("La cuenta no está registrada en la plataforma.", Status.NOT_FOUND);
        }
        return new Response("La cuenta existe.", Status.OK);
    }

    public static Response validarNoExistencia(Account account, AccountRepository accountRepository) {
        if (accountRepository.findById(account.getId()) != null) {
            return new Response("La cuenta ya está registrada en la plataforma.", Status.BAD_REQUEST);
        }
        return new Response("La cuenta no existe.", Status.OK);
    }

    public static Response validarBalance(Account account) {
        if (account.getBalance() < 0) {
            return new Response("El saldo de la cuenta no puede ser inferior a 0.", Status.BAD_REQUEST);
        }
        return new Response("El saldo de la cuenta es válido.", Status.OK);
    }

}
