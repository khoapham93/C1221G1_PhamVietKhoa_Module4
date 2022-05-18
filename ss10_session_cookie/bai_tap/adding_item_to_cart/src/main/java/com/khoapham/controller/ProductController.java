package com.khoapham.controller;

import com.khoapham.model.Cart;
import com.khoapham.model.Product;
import com.khoapham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop( @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Product productOptional = productService.findById(id);
        if (productOptional == null) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional);
        return "redirect:/shop";
    }
    @GetMapping("/minus/{id}")
    public String minusCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Product productOptional = productService.findById(id);
        if (productOptional == null) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.minusProduct(productOptional);
            return "redirect:/shopping-cart";
        }

        cart.minusProduct(productOptional);
        return "redirect:/shop";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Product productOptional = productService.findById(id);
        if (productOptional == null) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.removeProduct(productOptional);
            return "redirect:/shopping-cart";
        }
        cart.removeProduct(productOptional);
        return "redirect:/shop";
    }
}