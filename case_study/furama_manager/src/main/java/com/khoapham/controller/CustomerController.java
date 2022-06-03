package com.khoapham.controller;

import com.khoapham.dto.CustomerDto;
import com.khoapham.dto.CustomerHaveBooking;
import com.khoapham.exception.ObjectNotFound;
import com.khoapham.models.customer.Customer;
import com.khoapham.models.customer.CustomerType;
import com.khoapham.models.employee.Employee;
import com.khoapham.service.ICustomerService;
import com.khoapham.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> findAllCustomerType() {
        return this.iCustomerTypeService.findAll();
    }

    @GetMapping("")
    public String goListCustomers(Model model,
                                  @RequestParam Optional<String> name,
                                  @RequestParam Optional<String> phone,
                                  @RequestParam Optional<Integer> customerType,
                                  @PageableDefault(value = 5) Pageable pageable) {
        String nameVal = name.orElse("");
        String phoneVal = phone.orElse("");
        Integer customerTypeVal = customerType.orElse(-1);
        Page<Customer> customers = this.iCustomerService.findAll(nameVal, phoneVal, customerTypeVal, pageable);
        model.addAttribute("customers", customers);
        model.addAttribute("nameVal", nameVal);
        model.addAttribute("phoneVal", phoneVal);
        model.addAttribute("customerTypeVal", customerTypeVal);
        return "/customers/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "/customers/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated CustomerDto customerDto,
                       BindingResult bindingResult,
                       Model model) {

        new CustomerDto().validate(customerDto, bindingResult);
        this.iCustomerService.checkExists(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            model.addAttribute("customerDto", new CustomerDto());
            model.addAttribute("success", "Create customer successfully!");
        }
        return "/customers/create";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) throws ObjectNotFound {

        Customer customer = this.iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();

        BeanUtils.copyProperties(customer, customerDto);

        model.addAttribute("customerDto", customerDto);
        return "/customers/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated CustomerDto customerDto,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirect) {
        new CustomerDto().validate(customerDto, bindingResult);
        this.iCustomerService.checkExists(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            return "/customers/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            redirect.addFlashAttribute("success", "Update customer successfully!");
            return "redirect:/customers/";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirect) throws ObjectNotFound {
        Customer customer = this.iCustomerService.findById(id);
        this.iCustomerService.remove(customer);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers/";
    }

    @GetMapping("/customer-have-booking")
    public String getCustomerHaveBooking(Model model, @PageableDefault(value = 5) Pageable pageable) {
        Page<CustomerHaveBooking> customerHaveBookings = this.iCustomerService.findAllCustomerHaveBooking(pageable);
        model.addAttribute("customerHaveBookings", customerHaveBookings);
        return "/customers/listCustomerHaveBooking";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) throws ObjectNotFound {
        Customer customer = this.iCustomerService.findById(id);
        model.addAttribute("customer", customer);
        return "/customers/detail";
    }


    @ExceptionHandler(ObjectNotFound.class)
    public ModelAndView showNotFoundPage() {
        return new ModelAndView("notFound");
    }
}
