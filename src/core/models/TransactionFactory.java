/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import core.models.transactions.DepositTransaction;
import core.models.transactions.Transaction;
import core.models.transactions.TransferTransaction;
import core.models.transactions.WithdrawTransaction;

/**
 *
 * @author Janus
 */
public class TransactionFactory {
    public static Transaction createDeposit(Account account, double amount) {
        return new DepositTransaction(account, amount);
    }

    public static Transaction createWithdraw(Account account, double amount) {
        return new WithdrawTransaction(account, amount);
    }

    public static Transaction createTransfer(Account source, Account destination, double amount) {
        return new TransferTransaction(source, destination, amount);
    }
}
