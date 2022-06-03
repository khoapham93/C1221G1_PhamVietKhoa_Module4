package com.khoapham.controller;

import com.khoapham.dto.CustomerDto;
import com.khoapham.exception.ObjectNotFound;
import com.khoapham.models.customer.Customer;
import com.khoapham.models.customer.CustomerType;
import com.khoapham.service.ICustomerService;
import com.khoapham.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("customerRes")
public class RestCustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable int id) throws ObjectNotFound {

        Customer customer = this.iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        Map<String, Object> responseObjects = new HashMap<>();
        responseObjects.put("customerDto", customerDto);
        responseObjects.put("customerTypes", this.iCustomerTypeService.findAll());
        return new ResponseEntity<>(responseObjects, HttpStatus.OK);
    }

    @PatchMapping()
    public ResponseEntity<?> update(@Validated @RequestBody CustomerDto customerDto,
                                    BindingResult bindingResult) throws ObjectNotFound {
        Customer customerCheck = this.iCustomerService.findById(customerDto.getId());

        new CustomerDto().validate(customerDto, bindingResult);
        this.iCustomerService.checkExists(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            String error = "error";

            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            String success = "Update customer successfully!";
            return new ResponseEntity<>(success, HttpStatus.OK);
        }

    }

    @ExceptionHandler(ObjectNotFound.class)
    public ModelAndView showNotFoundPage() {
        return new ModelAndView("notFound");
    }
}
