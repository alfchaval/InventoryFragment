package com.example.usuario.inventoryfragment.db.repository;

import com.example.usuario.inventoryfragment.pojo.User;

import java.util.ArrayList;

/**
 * @author Alfonso Chamorro Valle
 * Repositorio de Useres
 */

public class UserRepository {

    /* Declaración */
    private ArrayList<User> Users;
    private static UserRepository userRepository;

    public UserRepository() {
        this.Users = new ArrayList<>();
        initialize();
    }

    /**
     * El método ha de ser privado para garantizar que solo hay una instancia de Repository
     */
    private void initialize() {
        saveUser(new User(1, "alfchaval", "Aa1.", "Alfonso Chamorro","alfchaval@hotmail.com", true, true));
        saveUser(new User(1, "user1", "Uu1.", "User 1","user1@user.com", false, false));
        saveUser(new User(1, "user2", "Uu2.", "User 2","user2@user.com", false, false));
    }

    /* Métodos */
    public static UserRepository getInstance() {
        if(userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    /**
     * Método que añade una dependencia
     * @param User
     */
    public int saveUser(User User) {
        Users.add(User);
        return User.get_ID();
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public boolean userExist(User user) {
        return false;
    }

}