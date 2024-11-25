/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.repository;

import core.models.User;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author Janus
 */
public class UserRepository {
    private final ArrayList<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }
    
    public User findById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public ArrayList<User> findAll() {
        return users;
    }
    
    public boolean exists(User user) {
        return users.contains(user);
    }
    
    public ArrayList<User> findAllOrderedById() {
    return (ArrayList<User>) users.stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
}
    
    
}
