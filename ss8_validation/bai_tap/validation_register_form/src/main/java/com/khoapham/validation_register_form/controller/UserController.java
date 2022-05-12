package com.khoapham.validation_register_form.controller;

import com.khoapham.validation_register_form.dto.UserDto;
import com.khoapham.validation_register_form.model.User;
import com.khoapham.validation_register_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String goIndex(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated UserDto userDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {

        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {

            return "index";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            this.iUserService.save(user);
            return "success";
        }

    }

}
