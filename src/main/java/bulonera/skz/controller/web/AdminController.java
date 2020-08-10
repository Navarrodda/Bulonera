package bulonera.skz.controller.web;

import bulonera.skz.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserController userController;

    @Autowired
    public AdminController(UserController userController) {
        this.userController = userController;
    }
}
