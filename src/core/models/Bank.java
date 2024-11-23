/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import core.validate.ValidationService;
import java.util.ArrayList;

/**
 *
 * @author Janus
 */
public class Bank {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final TransactionService transactionService;

    public Bank() {
        this.userRepository = new UserRepository();
        this.accountRepository = new AccountRepository();
        this.transactionService = new TransactionService();
    }

    // Agregar un nuevo usuario al banco
    public void addUser(User user) {
        userRepository.add(user);
    }

    // Crear una nueva cuenta y asignarla a un usuario
    public void createAccount(BasicAccount account) {
        ValidationService.validateUserExists(userRepository, account.getOwner());
        accountRepository.add(account);
    }

    // Realizar una transacción
    public Transaction processTransaction(Transaction transaction) {
        ValidationService.validateTransactionAccounts(accountRepository, transaction);
        if (transaction.getType() == TransactionType.WITHDRAW) {
            ValidationService.validateWithdrawAmount(transaction.getSourceAccount(), transaction.getAmount());
        } else if (transaction.getType() == TransactionType.TRANSFER) {
            ValidationService.validateTransferAmount(transaction.getSourceAccount(), transaction.getAmount());
        }
        transactionService.processTransaction(transaction);
        return transaction;
    }

    // Obtener listas de usuarios, cuentas y transacciones
    public ArrayList<User> getUsers() {
        return userRepository.findAll();
    }

    public ArrayList<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactionService.getTransactionHistory();
    }
    
    public ArrayList<User> getUsersOrderedById() {
        return userRepository.findAllOrderedById();
    }

    public ArrayList<Account> getAccountsOrderedById() {
        return accountRepository.findAllOrderedById();
    }

    public ArrayList<Transaction> getTransactionsOrderedByDate() {
        return transactionService.getTransactionsOrderedByDate();
    }

}
