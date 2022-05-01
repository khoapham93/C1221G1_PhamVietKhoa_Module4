package com.khoapham.controller;

import com.khoapham.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @Autowired
    private ITranslateService iTranslateService;

    @GetMapping(value = "/goTranslate")
    public String goTranslate() {
        return "translate";
    }

    @GetMapping(value = "/translate")
    public String translate(@RequestParam String english, Model model) {
        String vietnamese = this.iTranslateService.translate(english);
        model.addAttribute("vietnamese",vietnamese);
        model.addAttribute("english",english);
        return "translate";
    }
}
