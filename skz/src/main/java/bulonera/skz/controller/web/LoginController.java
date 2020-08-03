package bulonera.skz.controller.web;


import bulonera.skz.controller.UserController;
import bulonera.skz.exceptions.ExistingUser;
import bulonera.skz.model.User;
import bulonera.skz.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {


    private final UserController userController;
    private final SessionManager sessionManager;

    @Autowired
    public LoginController(UserController userController, SessionManager sessionManager) {
        this.userController = userController;
        this.sessionManager = sessionManager;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) throws ExistingUser
    {
        return this.userController.addUser(user);
    }
}
