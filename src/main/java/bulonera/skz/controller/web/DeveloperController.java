package bulonera.skz.controller.web;

import bulonera.skz.controller.UserController;
import bulonera.skz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/developer")
public class DeveloperController {

    private final UserController userController;

    @Autowired
    public DeveloperController(UserController userController) {
        this.userController = userController;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> bringAllUsers(){
        return this.userController.bringAllUsers();
    }



}
