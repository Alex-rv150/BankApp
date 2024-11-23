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
public class Bank {
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;
    private ArrayList<User> users;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.users = new ArrayList<>();
    }

}
