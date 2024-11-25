/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.validators;

import Controladores.utils.Response;
import Controladores.utils.Status;
import core.models.Account;

/**
 *
 * @author arang
 */
public class TransactionValidator {

    public static Response validateWithdrawal(Account fromAccount, double amount) {
        if (fromAccount == null) {
            return new Response("La cuenta origen no existe.", Status.NOT_FOUND);
        }
        if (amount <= 0) {
            return new Response("El monto a retirar debe ser mayor que 0.", Status.BAD_REQUEST);
        }
        if (fromAccount.getBalance() < amount) {
            return new Response("El saldo de la cuenta es insuficiente para esta transacción.", Status.BAD_REQUEST);
        }
        return new Response("Validación exitosa.", Status.OK);
    }

    public static Response validateDeposit(Account toAccount, double amount) {
        if (toAccount == null) {
            return new Response("La cuenta destino no existe.", Status.NOT_FOUND);
        }
        if (amount <= 0) {
            return new Response("El monto a depositar debe ser mayor que 0.", Status.BAD_REQUEST);
        }
        return new Response("Validación exitosa.", Status.OK);
    }

    public static Response validateTransfer(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount == null || toAccount == null) {
            return new Response("Ambas cuentas deben estar registradas en el sistema.", Status.NOT_FOUND);
        }
        if (amount <= 0) {
            return new Response("El monto a transferir debe ser mayor que 0.", Status.BAD_REQUEST);
        }
        if (fromAccount.getBalance() < amount) {
            return new Response("El saldo de la cuenta origen es insuficiente para transferir.", Status.BAD_REQUEST);
        }
        return new Response("Validación exitosa.", Status.OK);
    }
}
