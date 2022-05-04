package com.khoapham.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import java.util.Map;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String showCondiment() {
        return "home";
    }

    @GetMapping("/save")
    public String save(ServletRequest request, Model model) {
        Map<String, String[]> paramMap = request.getParameterMap();

        if (paramMap.containsKey("condiments")) {
            model.addAttribute("condiments", paramMap.get("condiments"));
        } else {
            model.addAttribute("error", "You choose nothing!");
        }
        return "save";
    }
}
