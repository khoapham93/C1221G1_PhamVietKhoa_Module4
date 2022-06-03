package com.khoapham.controller;

import com.khoapham.dto.DateRangeDto;
import com.khoapham.dto.OrdersDto;
import com.khoapham.model.Orders;
import com.khoapham.model.Product;
import com.khoapham.model.ProductType;
import com.khoapham.service.IOrderService;
import com.khoapham.service.IProductService;
import com.khoapham.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class OderController {
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductTypeService iProductTypeService;

    @ModelAttribute("products")
    public List<Product> getAllProduct() {
        return this.iProductService.findAll();
    }

    @ModelAttribute("productTypes")
    public List<ProductType> getAllProductType() {
        return this.iProductTypeService.findAll();
    }

    @GetMapping("")
    public String showOrder(@ModelAttribute @Validated DateRangeDto dateRangeDto,
                            BindingResult bindingResult,
                            Model model,
                            @RequestParam(defaultValue = "0") Integer page,
                            @RequestParam(defaultValue = "5") Integer pageSize,
                            @RequestParam Optional<String> top,
                            @RequestParam Optional<LocalDate> fromDate,
                            @RequestParam Optional<LocalDate> toDate) {

        LocalDate fromDateVal = fromDate.orElse(null);
        LocalDate toDateVal = toDate.orElse(null);
        String topVal = top.orElse("");
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Orders> orders;

        new DateRangeDto().validate(dateRangeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            toDateVal = fromDateVal.minusDays(1);
            orders = this.iOrderService.findAll(fromDateVal, toDateVal, pageable);
        } else {
            if ("".equals(topVal)) {
                orders = this.iOrderService.findAll(fromDateVal, toDateVal, pageable);
            } else {
                orders = this.iOrderService.findAllAndOrderTop(fromDateVal, toDateVal, pageable);
            }
        }
        model.addAttribute("dateRangeDto", dateRangeDto);
        model.addAttribute("topVal", topVal);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("orders", orders);
        model.addAttribute("fromDateVal", fromDateVal);
        model.addAttribute("toDateVal", toDateVal);
        return "index";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        Orders orders = this.iOrderService.findById(id);
        OrdersDto ordersDto = new OrdersDto();
        BeanUtils.copyProperties(orders, ordersDto);
        model.addAttribute("ordersDto", ordersDto);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated OrdersDto ordersDto,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirect) {

        new OrdersDto().validate(ordersDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("ordersDto", ordersDto);
            return "/edit";
        } else {
            Orders orders = new Orders();
            BeanUtils.copyProperties(ordersDto, orders);
            iOrderService.save(orders);
            redirect.addFlashAttribute("success", "Update order successfully!");
            return "redirect:";
        }
    }

}
