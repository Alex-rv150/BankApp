/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

/**
 *
 * @author Janus
 */
public class WithdrawTransaction implements Transaction{
    private final Account sourceAccount;
    private final double amount;

    public WithdrawTransaction(Account sourceAccount, double amount) {
        this.sourceAccount = sourceAccount;
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (!sourceAccount.withdraw(amount)) {
            throw new IllegalStateException("Insufficient funds.");
        }
    }
    
    @Override
    public String getType() {
        return "WITHDRAW";
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
}
