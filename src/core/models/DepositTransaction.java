/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

/**
 *
 * @author Janus
 */
public class DepositTransaction implements Transaction{
    private final Account destinationAccount;
    private final double amount;

    public DepositTransaction(Account destinationAccount, double amount) {
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    @Override
    public void execute() {
        destinationAccount.deposit(amount);
    }
    
    @Override
    public String getType() {
        return "DEPOSIT";
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
}
