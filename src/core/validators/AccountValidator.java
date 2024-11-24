/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validators;

import core.models.Account;
import core.models.AccountRepository;
import core.models.UserRepository;
import java.util.regex.Pattern;

/**
 *
 * @author arang
 */
public class AccountValidator {

    public static void validateAccount(Account account, UserRepository userRepository, AccountRepository accountRepository) {
        validarBalance(account);
        UserValidator.validateUSersExits(userRepository, account.getOwner());
        validarFormato(account.getId());
        validarNoExistencia(account, accountRepository);
    }

    public static void validarFormato(String id) {
        String regex = "\\d{3}-\\d{6}-\\d{2}";
        if (!Pattern.matches(regex, id)) {
            throw new ValidationException("El ID de la cuenta no sigue el formato requerido: XXX-XXXXXX-XX.");
        }
    }

    public static void validarExistencia(Account account, AccountRepository accountRepository) {
        if (accountRepository.findById(account.getId()) == null) {
            throw new ValidationException("La cuenta no está registrada en la plataforma.");
        }
    }

    public static void validarNoExistencia(Account account, AccountRepository accountRepository) {
        if (accountRepository.findById(account.getId()) != null) {
            throw new ValidationException("La cuenta ya está registrada en la plataforma.");
        }
    }

    public static void validarBalance(Account account) {
        if (account.getBalance() < 0) {
            throw new ValidationException("El saldo de la cuenta no puede ser inferior a 0.");
        }
    }

}
