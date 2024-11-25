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
 * @author edangulo
 */
public interface Transaction {
    
    void execute();
    
    TransactionType getType();
    String getSourceAccountId();
    String getDestinationAccountId();
    double getAmount();
    Account getDestinationAccount();
    Account getSourceAccount();
    LocalDateTime getTimestamp();
    
}
