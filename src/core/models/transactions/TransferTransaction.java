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
public class TransferTransaction implements Transaction{
    private final Account sourceAccount;
    private final Account destinationAccount;
    private final double amount;
    private final LocalDateTime timestamp;

    public TransferTransaction(Account sourceAccount, Account destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // Captura la fecha y hora actuales
    }

    @Override
    public void execute() {
        if (!sourceAccount.withdraw(amount)) {
            throw new IllegalStateException("Insufficient funds.");
        }
        destinationAccount.deposit(amount);
    }
    
    @Override
    public TransactionType getType() {
        return TransactionType.TRANSFER;
    }

    @Override
    public String getSourceAccountId() {
        return sourceAccount.getId();
    }

    @Override
    public String getDestinationAccountId() {
        return destinationAccount.getId();
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
        return destinationAccount;
    }
    
    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
