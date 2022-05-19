package com.khoapham.controller;

import com.khoapham.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute(value = "cart",required = false) Cart cart) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @PostMapping("/buy")
    public ModelAndView payCart(@SessionAttribute(value = "cart",required = false) Cart cart) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("/pay");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @PostMapping("/confirm")
    public ModelAndView confirm(@SessionAttribute(value = "cart",required = false) Cart cart,
                                @RequestParam String name,
                                @RequestParam String address) {
        ModelAndView modelAndView;
        modelAndView = new ModelAndView("/success");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
}
