package pl.adamLupinski.myMedicinesApp.myMedicines.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.User;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showReg(Model model){
        model.addAttribute("user", new User());
        return "index";
    }
}
