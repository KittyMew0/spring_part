package Controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Service.UserService;
import User.User;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final UserService userService;

    @Autowired
    public TaskController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return userService.getAllUsers().stream()
                .filter(user -> user.getAge() == age)
                .toList();
    }

    @GetMapping("/calc")
    public Double calculateAverageAge() {
        List<User> users = userService.getAllUsers();
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
}
