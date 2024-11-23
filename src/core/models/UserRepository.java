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
}
