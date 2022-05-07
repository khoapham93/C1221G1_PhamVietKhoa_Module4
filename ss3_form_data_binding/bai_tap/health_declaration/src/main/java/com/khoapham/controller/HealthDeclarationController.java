package com.khoapham.controller;

import com.khoapham.model.HealthDeclaration;
import com.khoapham.service.IHealthDeclarationService;
import com.khoapham.util.AttribueList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HealthDeclarationController {
    @Autowired
    private IHealthDeclarationService iHealthDeclarationService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("years", AttribueList.getYearList());
        model.addAttribute("genders", AttribueList.getGenders());
        model.addAttribute("nations", AttribueList.getNations());
        model.addAttribute("vehicles", AttribueList.getVehicles());
        model.addAttribute("healthDeclaration", this.iHealthDeclarationService.getHealthDeclaration());
        return "form";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute HealthDeclaration healthDeclaration,Model model) {
        this.iHealthDeclarationService.save(healthDeclaration);
        model.addAttribute("healthDeclaration",healthDeclaration);
        return "save";
    }

}
