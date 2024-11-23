/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

/**
 *
 * @author Janus
 */
public class BasicAccount implements Account{
    
    private final String id;
    private final User owner;
    private double balance;
    
    public BasicAccount(String id, User owner) {
        this.id = id;
        this.owner = owner;
        this.balance = 0;
        this.owner.addAccount(this);
    }
    
    public BasicAccount(String id, User owner, double initialBalance) {
        this.id = id;
        this.owner = owner;
        this.balance = initialBalance;
        this.owner.addAccount(this);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public User getOwner() {
        return owner;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.balance += amount;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive.");
        }
        if (amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    
}
