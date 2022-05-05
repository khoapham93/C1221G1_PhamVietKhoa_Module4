package com.khoapham.controller;

import com.khoapham.model.Setting;
import com.khoapham.service.IEmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailSettingController {
    @Autowired
    private IEmailSettingService iEmailSettingService;

    @GetMapping(value = "/setting")
    public String goSetting(Model model) {
        model.addAttribute("setting", this.iEmailSettingService.getSetting());
        return "setting";
    }
    @PostMapping(value = "/setting")
    public String setting(@ModelAttribute Setting setting, RedirectAttributes redirectAttributes) {
        this.iEmailSettingService.save(setting);
        redirectAttributes.addFlashAttribute ("message", "Setting update successful");
        return "redirect:setting";
    }
}
