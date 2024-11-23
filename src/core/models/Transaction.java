/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;


/**
 *
 * @author edangulo
 */
public interface Transaction {
    
    void execute();
    
    String getType();
    String getSourceAccountId();
    String getDestinationAccountId();
    double getAmount();
    
}
