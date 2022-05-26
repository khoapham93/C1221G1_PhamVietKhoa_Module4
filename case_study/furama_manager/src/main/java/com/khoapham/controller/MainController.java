package com.khoapham.controller;

import com.khoapham.service.IAppRoleService;
import com.khoapham.service.IAppUserService;
import com.khoapham.service.IUserRoleService;
import com.khoapham.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
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
    public String loginPage(Model model) {
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
