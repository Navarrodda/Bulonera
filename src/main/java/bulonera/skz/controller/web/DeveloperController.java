package bulonera.skz.controller.web;

import bulonera.skz.controller.UserController;
import bulonera.skz.exceptions.UserException;
import bulonera.skz.model.User;
import bulonera.skz.projections.UsersFilter;
import bulonera.skz.session.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/developer")
public class DeveloperController {

    private final UserController userController;
    private final SessionManager sessionManager;


    @Autowired
    public DeveloperController(UserController userController, SessionManager sessionManager) {
        this.userController = userController;
        this.sessionManager = sessionManager;
    }



    private Object getCurrentUser(String sessionToken) throws UserException {
        User user = sessionManager.getCurrentUser(sessionToken);
        if(user == null) { return new UserException("User not logged");
        } else { return user; }
    }

    @GetMapping("/users")
    public ResponseEntity<List<UsersFilter>> bringAllUsers(@RequestHeader("Authorization") String sessionToken) throws UserException{
        User currentUser = this.sessionManager.getCurrentUser(sessionToken);
        return this.userController.bringAllUsers();
    }



}
