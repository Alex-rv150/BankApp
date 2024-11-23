/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.util.ArrayList;

/**
 *
 * @author Janus
 */
public class TransactionService {
    private final ArrayList<Transaction> transactionHistory = new ArrayList<>();

    public void processTransaction(Transaction transaction) {
        transaction.execute(); // Lógica delegada a la transacción
        transactionHistory.add(transaction);
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
