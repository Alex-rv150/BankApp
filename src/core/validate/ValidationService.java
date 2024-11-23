/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validate;

import core.models.Account;
import core.models.AccountRepository;
import core.models.Transaction;
import core.models.TransactionType;
import core.models.User;
import core.models.UserRepository;
import java.util.regex.Pattern;

/**
 *
 * @author Janus
 */
public class ValidationService {
    
    // Validación del ID del usuario
    public static void validateUserId(int id) {
        if (id < 0 || id > 999_999_999) {
            throw new IllegalArgumentException("El ID debe ser mayor o igual a 0 y tener como máximo 9 dígitos.");
        }
    }
    
    // Validación del nombre y apellido
    public static void validateName(String name, String fieldName) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " no puede estar vacío.");
        }
    }
    
    public static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("La edad debe ser mayor o igual a 18.");
        }
    }
    
    // Validación para verificar si un usuario está registrado
    public static void validateUserExists(UserRepository userRepository, User user) {
        if (user == null || !userRepository.exists(user)) {
            throw new IllegalArgumentException("El usuario no está registrado en la plataforma.");
        }
    }
    
    // Validación del formato del ID de la cuenta
    public static void validateAccountIdFormat(String accountId) {
        String regex = "\\d{3}-\\d{6}-\\d{2}";
        if (!Pattern.matches(regex, accountId)) {
            throw new IllegalArgumentException("El ID de la cuenta no sigue el formato requerido: XXX-XXXXXX-XX.");
        }
    }
    
    // Validación del saldo inicial
    public static void validateInitialBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser inferior a 0.");
        }
    }
    
    // Validar que una cuenta exista en el repositorio
    public static void validateAccountExists(AccountRepository accountRepository, Account account) {
        if (account == null || !accountRepository.exists(account)) {
            throw new IllegalArgumentException("La cuenta no existe en la plataforma.");
        }
    }
    
    // Validar que las cuentas involucradas en la transacción existen
    public static void validateTransactionAccounts(AccountRepository accountRepository, Transaction transaction) {
        if (transaction == null) {
        throw new IllegalArgumentException("La transacción no puede ser nula.");
        }

        TransactionType type = transaction.getType();

    if (type == TransactionType.TRANSFER) {
        // Validar origen y destino en una transferencia
        Account source = transaction.getSourceAccount();
        Account destination = transaction.getDestinationAccount();

        if (source == null || destination == null) {
            throw new IllegalArgumentException("Las cuentas de origen y destino deben estar definidas para una transferencia.");
        }

        validateAccountExists(accountRepository, source);
        validateAccountExists(accountRepository, destination);

    } else if (type == TransactionType.WITHDRAW) {
        // Validar cuenta de origen en un retiro
        Account source = transaction.getSourceAccount();

        if (source == null) {
            throw new IllegalArgumentException("La cuenta de origen debe estar definida para un retiro.");
        }

        validateAccountExists(accountRepository, source);

    } else if (type == TransactionType.DEPOSIT) {
        // Validar cuenta de destino en un depósito
        Account destination = transaction.getDestinationAccount();

        if (destination == null) {
            throw new IllegalArgumentException("La cuenta de destino debe estar definida para un depósito.");
        }

        validateAccountExists(accountRepository, destination);

    } else {
        throw new IllegalArgumentException("El tipo de transacción no es válido.");
    }
    }
    
    public static void validateWithdrawAmount(Account sourceAccount, double amount) {
    if (sourceAccount == null) {
        throw new IllegalArgumentException("La cuenta de origen no puede ser nula.");
    }
    if (amount > sourceAccount.getBalance()) {
        throw new IllegalArgumentException("El monto a retirar no puede ser mayor al saldo disponible en la cuenta.");
    }
}
    
    public static void validateTransferAmount(Account sourceAccount, double amount) {
        if (sourceAccount == null) {
            throw new IllegalArgumentException("La cuenta de origen no puede ser nula.");
        }
        if (amount > sourceAccount.getBalance()) {
            throw new IllegalArgumentException("El monto a transferir no puede ser mayor al saldo disponible en la cuenta origen.");
        }
    }
    
    
    
}
