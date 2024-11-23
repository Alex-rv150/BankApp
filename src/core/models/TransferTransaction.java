/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

/**
 *
 * @author Janus
 */
public class TransferTransaction implements Transaction{
    private final Account sourceAccount;
    private final Account destinationAccount;
    private final double amount;

    public TransferTransaction(Account sourceAccount, Account destinationAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (!sourceAccount.withdraw(amount)) {
            throw new IllegalStateException("Insufficient funds.");
        }
        destinationAccount.deposit(amount);
    }
    
    @Override
    public String getType() {
        return "TRANSFER";
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
}
