/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.transactions;

import core.models.Account;
import core.models.TransactionType;
import java.time.LocalDateTime;

/**
 *
 * @author Janus
 */
public class WithdrawTransaction implements Transaction{
    private final Account sourceAccount;
    private final double amount;
    private final LocalDateTime timestamp;

    public WithdrawTransaction(Account sourceAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // Captura la fecha y hora actuales
    }

    @Override
    public void execute() {
        if (!sourceAccount.withdraw(amount)) {
            throw new IllegalStateException("Insufficient funds.");
        }
    }
    
    @Override
    public TransactionType getType() {
        return TransactionType.WITHDRAW;
    }

    @Override
    public String getSourceAccountId() {
        return sourceAccount.getId();
    }

    @Override
    public String getDestinationAccountId() {
        return "null";
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Account getSourceAccount() {
        return sourceAccount;
    }

    @Override
    public Account getDestinationAccount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
