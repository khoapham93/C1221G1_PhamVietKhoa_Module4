package com.khoapham.controller;

import com.khoapham.model.Product;
import com.khoapham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String index(Model model,
                        @RequestParam Optional<String> keyword1,
                        @RequestParam Optional<String> keyword2,
                        @RequestParam Optional<String> keyword3,
                        @PageableDefault(value = 5) Pageable pageable) {

        String keywordVal1 = keyword1.orElse("");
        String keywordVal2 = keyword2.orElse("");
        String keywordVal3 = keyword3.orElse("");
        Page<Product> productList = iProductService.findAllByNameAndManufacturerAndPrice(keywordVal1, keywordVal2, keywordVal3, pageable);
        model.addAttribute("products", productList);
        model.addAttribute("keywordVal1", keywordVal1);
        model.addAttribute("keywordVal2", keywordVal2);
        model.addAttribute("keywordVal3", keywordVal3);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

//    @GetMapping("/search")
//    public String search(Model model, @RequestParam String keyword) {
//        List<Product> productList = iProductService.search(keyword);
//        model.addAttribute("products", productList);
//        return "/index";
//    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirect) {
        iProductService.save(product);
        redirect.addFlashAttribute("success", "Create product successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirect) {
        iProductService.save(product);
        redirect.addFlashAttribute("success", "Update product successfully!");

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }
}
