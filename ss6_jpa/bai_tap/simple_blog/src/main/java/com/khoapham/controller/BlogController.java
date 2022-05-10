package com.khoapham.controller;

import com.khoapham.model.Blog;
import com.khoapham.service.IBlogService;

import com.khoapham.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String index(Model model) {
        List<Blog> productList = iBlogService.findAll();
        model.addAttribute("blogs", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", this.iCategoryService.findAll());
        return "/create";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam String keyword) {
        List<Blog> productList = iBlogService.search(keyword);
        model.addAttribute("blogs", productList);
        return "/index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        iBlogService.save(blog);
        redirect.addFlashAttribute("success", "Create blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        iBlogService.save(blog);
        redirect.addFlashAttribute("success", "Update blog successfully!");

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        iBlogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/view";
    }
}
