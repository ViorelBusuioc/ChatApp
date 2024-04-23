package dev.vio.ChatApp.dao;

import dev.vio.ChatApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByNameAndPassword(String userName, String password);

    Optional<User> findByName(String userName);
}
