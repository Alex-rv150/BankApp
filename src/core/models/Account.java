/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

/**
 *
 * @author edangulo
 */
public interface Account {
    
    String getId();
    User getOwner();
    double getBalance();
    void deposit(double amount);
    boolean withdraw(double amount);

    
    
}
