/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.time.LocalDateTime;

/**
 *
 * @author Janus
 */
public class DepositTransaction implements Transaction{
    private final Account destinationAccount;
    private final double amount;
    private final LocalDateTime timestamp;

    public DepositTransaction(Account destinationAccount, double amount) {
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // Captura la fecha y hora actuales
    }

    @Override
    public void execute() {
        destinationAccount.deposit(amount);
    }
    
    @Override
    public TransactionType getType() {
        return TransactionType.DEPOSIT;
    }

    @Override
    public String getSourceAccountId() {
        return "None";
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
    public Account getDestinationAccount() {
        return destinationAccount;
    }

    @Override
    public Account getSourceAccount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
