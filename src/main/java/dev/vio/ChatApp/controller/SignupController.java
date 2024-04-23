package dev.vio.ChatApp.controller;

import dev.vio.ChatApp.entity.User;
import dev.vio.ChatApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class SignupController {

    private UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signup(Model model) {

        model.addAttribute("user", new User());
        return "signup.html";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String userName, @RequestParam("password") String password,
                       @ModelAttribute("user") User user, Model model) {

        Optional<User> result = Optional.ofNullable(userService.findByName(userName));
        if (result.isPresent()) {
            model.addAttribute("error", "User " + userName + " already exists");
            return "signup.html";
        } else {
            userService.save(user);
            return "redirect:/";
        }

    }


}
