package com.example.secondsemhw.controllers;

import ch.qos.logback.core.model.Model;
import com.example.secondsemhw.model.User;
import com.example.secondsemhw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String FindAll(Model model) {
        List<User> users = userService.findAll();

        model.addAttribute("users", users);

        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm (User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        return userService.deleteById();
    }

}