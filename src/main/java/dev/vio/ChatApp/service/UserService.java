package dev.vio.ChatApp.service;

import dev.vio.ChatApp.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    User save(User user);

    void deleteById(int id);

    User findByNameAndPassword(String userName, String password);

    User findByName(String userName);
}
