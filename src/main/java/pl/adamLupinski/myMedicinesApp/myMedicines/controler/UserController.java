package pl.adamLupinski.myMedicinesApp.myMedicines.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.adamLupinski.myMedicinesApp.myMedicines.dao.UserRepository;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.Medicine;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.User;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.UserMedicine;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user){
        userRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("/addMedicine")
    public String addMedicine(@ModelAttribute Medicine medicine, Long id){
    }

}
