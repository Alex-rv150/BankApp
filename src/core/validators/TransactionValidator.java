/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validators;

import core.models.Account;

/**
 *
 * @author arang
 */
public class TransactionValidator {

    public static void validateWithdrawal(Account fromAccount, double amount) {
        if (fromAccount == null) {
                    throw new ValidationException("La cuenta origen no existe.");
        }
        
        if (amount <= 0) {
            throw new ValidationException("El monto a retirar debe ser mayor que 0.");
        }
        if (fromAccount.getBalance() < amount) {
            throw new ValidationException("El saldo de la cuenta es insuficiente para esta transacción.");
        }
        
    }

    public static void validateDeposit(Account toAccount, double amount) {
        if (toAccount == null) {
                    throw new ValidationException("La cuenta destino no existe.");
                }
        if (amount <= 0) {
            throw new ValidationException("El monto a Depositar debe ser mayor que 0.");
        }

        
    }

    public static void validateTransfer(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount == null || toAccount == null) {
            throw new ValidationException("Ambas cuentas deben estar registradas en el sistema.");
        }
        if (amount <= 0) {
            throw new ValidationException("El monto a transferir debe ser mayor que 0.");
        }
        if (fromAccount.getBalance() < amount) {
            throw new ValidationException("El saldo de la cuenta origen es insuficiente para transferir.");
        }
    }
}
