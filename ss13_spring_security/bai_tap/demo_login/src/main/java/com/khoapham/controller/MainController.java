package com.khoapham.controller;
import java.security.Principal;

import com.khoapham.dto.AppUserDto;
import com.khoapham.model.AppUser;
import com.khoapham.service.IAppUserService;
import com.khoapham.util.WebUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private IAppUserService iAppUserService;

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "adminPage";
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "403Page";
    }
    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(Model model) {
        AppUserDto appUserDto = new AppUserDto();
        model.addAttribute("userDto",appUserDto);
        return "signUpPage";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String adminPage(@Validated @ModelAttribute AppUserDto userDto,
            BindingResult bindingResult,
            Model model, Principal principal) {

        new AppUserDto().validate(userDto,bindingResult);
        this.iAppUserService.userNameExists(userDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("userDto", userDto);
            return "signUpPage";
        }else {
            AppUser appUser = new AppUser();
            BeanUtils.copyProperties(userDto,appUser);
            iAppUserService.registerNewUserAccount(appUser);
            return "signUpSuccess";
        }

    }
}