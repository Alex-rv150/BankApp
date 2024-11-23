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
public class AccountRepository {
    private final ArrayList<Account> accounts = new ArrayList<>();

    public void add(Account account) {
        accounts.add(account);
    }
    
    public Account findById(String accountId) {
        return accounts.stream().filter(account -> account.getId().equals(accountId)).findFirst().orElse(null);
    }

    public ArrayList<Account> findAll() {
        return accounts;
    }
}
