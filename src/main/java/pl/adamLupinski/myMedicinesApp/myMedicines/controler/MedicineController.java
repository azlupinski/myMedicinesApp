package pl.adamLupinski.myMedicinesApp.myMedicines.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.adamLupinski.myMedicinesApp.myMedicines.dao.MedicineRepository;
import pl.adamLupinski.myMedicinesApp.myMedicines.model.Medicine;

@Controller
@RequestMapping("/medicines")
public class MedicineController {

    private MedicineRepository medicineRepository;

    @Autowired
    public MedicineController (MedicineRepository medicineRepository){
        this.medicineRepository = medicineRepository;
    }

    @GetMapping("/medicineReg")
    public String registerMedicineForm(Model model){
        model.addAttribute("medicine", new Medicine());
        return "medicine-reg";
    }

    @PostMapping("/save")
    public String addMedicine(@ModelAttribute Medicine medicine){
        medicineRepository.save(medicine);
        return "index";
    }

}
