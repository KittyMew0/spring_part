package Controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Service.RegistrationService;
import Service.UserService;
import User.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final RegistrationService registrationService;
    private final UserService userService;

    @Autowired
    public UserController(RegistrationService registrationService, UserService userService) {
        this.registrationService = registrationService;
        this.userService = userService;
    }

    @PostMapping("/body")
    public User addUser(@RequestBody User user) {
        return registrationService.processRegistration(user.getName(), user.getAge(), user.getEmail());
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/params")
    public User addUserFromParams(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        return registrationService.processRegistration(name, age, email);
    }
}
