package bulonera.skz.controller;

import bulonera.skz.exceptions.ExistingUser;
import bulonera.skz.model.User;
import bulonera.skz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity addUser(User user) throws ExistingUser {
        return this.userService.addUser(user);
    }
}
