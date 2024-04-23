package dev.vio.ChatApp.service;

import dev.vio.ChatApp.dao.UserRepository;
import dev.vio.ChatApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {

        Optional<User> result = userRepository.findById(id);
        User user = null;
        if(result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Did not find the user with the id: " + id);
        }
        return user;
    }

    @Override
    public User findByNameAndPassword(String userName, String password) {

        Optional<User> result = userRepository.findByNameAndPassword(userName, password);
        User user = null;
        if(result.isPresent()) {
            user = result.get();
        } else {
            LocalDateTime date = LocalDateTime.now();
            System.out.println(date + " -> Incorrect username: " + userName + " or password");
        }
        return user;
    }

    @Override
    public User findByName(String userName) {

        Optional<User> result = userRepository.findByName(userName);
        User user = null;
        if(result.isPresent()) {
            user = result.get();
        } else {
            LocalDateTime date = LocalDateTime.now();
            System.out.println(date + "No user with the name: " + userName);
        }
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
