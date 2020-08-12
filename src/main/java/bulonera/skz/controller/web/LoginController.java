package bulonera.skz.controller.web;


import bulonera.skz.controller.UserController;
import bulonera.skz.dto.LoginRequestDto;
import bulonera.skz.exceptions.ExistingUser;
import bulonera.skz.exceptions.InvalidLoginException;
import bulonera.skz.exceptions.UserException;
import bulonera.skz.exceptions.ValidationException;
import bulonera.skz.model.User;
import bulonera.skz.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
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
    { return this.userController.addUser(user); }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDto loginRequestDto) throws ValidationException, UserException, InvalidLoginException {
        return this.userController.login(loginRequestDto,sessionManager); }


    @PostMapping("/logout")
    public ResponseEntity logout(@RequestHeader("Authorization") String token) {
        this.sessionManager.sessionRemove(token);
        return ResponseEntity.ok().build();
    }

}
