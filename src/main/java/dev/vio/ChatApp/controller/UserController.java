package dev.vio.ChatApp.controller;

import dev.vio.ChatApp.entity.User;
import dev.vio.ChatApp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/validateUsername")
    public ResponseEntity<String> validateUsername(@RequestBody Map<String, String> requestBody) {

        String username = requestBody.get("username");
        String password = requestBody.get("password");
        Optional<User> result = Optional.ofNullable(userService.findByNameAndPassword(username, password));
        if (result.isPresent()) {
            return ResponseEntity.ok().body("Authentication successful");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect username or password");
        }
    }

}
