package com.khoapham.controller;

import com.khoapham.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping(value = "/")
    public String goHomepage() {
        return "index";
    }

    @PostMapping("/cal")
    public String calculator(@RequestParam Double number1,
                             @RequestParam Double number2,
                             @RequestParam String operator,
                             Model model) {
        Double result = null;
        String error = null;
        try {
            result = this.iCalculatorService.calculator(number1, number2, operator);
        } catch (ArithmeticException a) {
            error = a.getMessage();
        }

        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("operator", operator);
        model.addAttribute("result", result);
        model.addAttribute("error", error);

        return "index";
    }
}
