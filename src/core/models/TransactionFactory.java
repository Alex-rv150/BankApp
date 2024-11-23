/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

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
