/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import core.models.transactions.Transaction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

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
    
    public ArrayList<Transaction> getTransactionsOrderedByDate() {
    return (ArrayList<Transaction>) transactionHistory.stream()
                             .sorted(Comparator.comparing(Transaction::getTimestamp).reversed())
                             .collect(Collectors.toList());
}
}
