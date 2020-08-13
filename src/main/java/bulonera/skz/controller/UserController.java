package bulonera.skz.controller;

import bulonera.skz.dto.LoginRequestDto;
import bulonera.skz.exceptions.ExistingUser;
import bulonera.skz.exceptions.InvalidLoginException;
import bulonera.skz.exceptions.UserException;
import bulonera.skz.exceptions.ValidationException;
import bulonera.skz.model.User;
import bulonera.skz.projections.UsersFilter;
import bulonera.skz.service.UserService;
import bulonera.skz.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    public ResponseEntity login(LoginRequestDto loginRequestDto, SessionManager sessionManager) throws ValidationException, UserException, InvalidLoginException {
        return this.userService.login(loginRequestDto, sessionManager);
    }

    public ResponseEntity<List<UsersFilter>> bringAllUsers(){
        return this.userService.bringAllUsers();
    }
}
