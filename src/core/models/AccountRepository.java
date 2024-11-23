/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

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
    
    public boolean exists(Account account) {
        return accounts.contains(account);
    }
    
    public ArrayList<Account> findAllOrderedById() {
    return (ArrayList<Account>) accounts.stream()
                   .sorted(Comparator.comparing(Account::getId))
                   .collect(Collectors.toList());
}
}
