/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

/**
 *
 * @author edangulo
 */
public abstract class Account {
    protected final String accountId;
    protected final User owner;
    protected double balance;
    
    public Account(String accountId, User owner, double balance) {
        this.accountId = accountId;
        this.owner = owner;
        this.balance = balance;
    }
    
    public abstract String getId();
    public abstract User getOwner();
    public abstract double getBalance();
    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);

    
    
    
    
    
    
}
