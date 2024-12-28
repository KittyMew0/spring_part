package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import User.User;

@Service
public class RegistrationService {
    private final UserService userService;
    private final NotificationService notificationService;

    @Autowired
    public RegistrationService(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public User processRegistration(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        User savedUser = userService.saveUser(user);
        notificationService.notify("User registered: " + savedUser.getName());
        return savedUser;
    }
}
