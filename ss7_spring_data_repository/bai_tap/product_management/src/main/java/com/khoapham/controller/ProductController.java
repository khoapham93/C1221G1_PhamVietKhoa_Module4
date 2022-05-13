package com.khoapham.controller;

import com.khoapham.dto.ProductDto;
import com.khoapham.model.Manufacturer;
import com.khoapham.model.Product;
import com.khoapham.service.IManufacturerService;
import com.khoapham.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private IManufacturerService iManufacturerService;

    @GetMapping("")
    public String index(Model model,
                        @RequestParam Optional<String> keyword1,
                        @RequestParam Optional<Integer> keyword2,
                        @RequestParam Optional<String> keyword3,
                        @PageableDefault(value = 5) Pageable pageable) {

        String keywordVal1 = keyword1.orElse("");
        int keywordVal2 = keyword2.orElse(-1);
        String keywordVal3 = keyword3.orElse("");
        Page<Product> productList = iProductService.findAllByNameAndManufacturerAndPrice(keywordVal1, keywordVal2, keywordVal3, pageable);
        List<Manufacturer> manufacturerList = this.iManufacturerService.findAll();
        model.addAttribute("products", productList);
        model.addAttribute("manufacturers", manufacturerList);
        model.addAttribute("keywordVal1", keywordVal1);
        model.addAttribute("keywordVal2", keywordVal2);
        model.addAttribute("keywordVal3", keywordVal3);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Manufacturer> manufacturerList = this.iManufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturerList);
        model.addAttribute("productDto", new ProductDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated ProductDto productDto,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirect) {

        new ProductDto().validate(productDto, bindingResult);
        this.iProductService.checkExists(productDto, bindingResult);
        if (bindingResult.hasErrors()) {
            List<Manufacturer> manufacturerList = this.iManufacturerService.findAll();
            model.addAttribute("manufacturers", manufacturerList);
            model.addAttribute("productDto", productDto);
            return "/create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            iProductService.save(product);
            redirect.addFlashAttribute("success", "Create product successfully!");
            return "redirect:";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {

        List<Manufacturer> manufacturerList = this.iManufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturerList);
        Product product = this.iProductService.findById(id);
        ProductDto productDto = new ProductDto();

        BeanUtils.copyProperties(product, productDto);

        model.addAttribute("productDto", productDto);
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated ProductDto productDto,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirect) {
        new ProductDto().validate(productDto, bindingResult);
        this.iProductService.checkExists(productDto, bindingResult);
        if (bindingResult.hasErrors()) {
            List<Manufacturer> manufacturerList = this.iManufacturerService.findAll();
            model.addAttribute("manufacturers", manufacturerList);
            model.addAttribute("productDto", productDto);
            return "/create";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            iProductService.save(product);
            redirect.addFlashAttribute("success", "Update product successfully!");
            return "redirect:";

        }

    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }
}
