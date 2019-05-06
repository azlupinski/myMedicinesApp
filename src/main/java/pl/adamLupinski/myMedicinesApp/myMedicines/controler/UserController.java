package pl.adamLupinski.myMedicinesApp.myMedicines.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.adamLupinski.myMedicinesApp.myMedicines.dao.UserRepository;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.Medicine;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.User;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.UserMedicine;
import pl.adamLupinski.myMedicinesApp.myMedicines.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userReg")
    public String registerUserForm(Model model){
        model.addAttribute("user", new User());
        return "user-reg";
    }


    @PostMapping("/save")
    public String saveUser(@ModelAttribute @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) return "user-reg";
        else {
            userService.addWithDefaultRole(user);
            return "index";
        }
    }


}
