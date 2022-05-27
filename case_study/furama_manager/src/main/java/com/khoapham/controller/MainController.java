package com.khoapham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {
    @GetMapping("/")
    public String goHomePage() {
        return "/index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            String message = "Hi " + principal.getName();
            model.addAttribute("message", message);
        }
        return "403Page";
    }

    @GetMapping("/logoutSuccessful")
    public String logoutSuccessfulPage() {
        return "redirect:/";
    }
}
