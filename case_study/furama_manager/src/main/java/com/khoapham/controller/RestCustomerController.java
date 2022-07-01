package com.khoapham.controller;

import com.khoapham.dto.CustomerDto;
import com.khoapham.exception.ObjectNotFound;
import com.khoapham.models.customer.Customer;
import com.khoapham.models.customer.CustomerType;
import com.khoapham.service.ICustomerService;
import com.khoapham.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("customerRes")
public class RestCustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public ResponseEntity<Page<Customer>> getAllBlog(@RequestParam Optional<String> name,
                                                     @RequestParam Optional<String> phone,
                                                     @RequestParam Optional<Integer> customerType,
                                                     @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        String nameVal = name.orElse("");
        String phoneVal = phone.orElse("");
        Integer customerTypeVal = customerType.orElse(-1);
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customers = this.iCustomerService.findAll(nameVal, phoneVal, customerTypeVal, pageable);
            return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> finById(@PathVariable int id) throws ObjectNotFound {

        Customer customer = this.iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) throws ObjectNotFound {
        Customer customer = this.iCustomerService.findById(id);
        this.iCustomerService.remove(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Validated @RequestBody CustomerDto customerDto,
                                    BindingResult bindingResult) throws ObjectNotFound {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(customerDto, HttpStatus.BAD_REQUEST);
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@Validated @RequestBody CustomerDto customerDto,
                                    BindingResult bindingResult) throws ObjectNotFound {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @ExceptionHandler(ObjectNotFound.class)
    public ModelAndView showNotFoundPage() {
        return new ModelAndView("notFound");
    }
}
