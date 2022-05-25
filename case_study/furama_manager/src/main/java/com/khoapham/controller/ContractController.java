package com.khoapham.controller;

import com.khoapham.dto.ContractDto;
import com.khoapham.models.contract.Contract;
import com.khoapham.models.customer.Customer;
import com.khoapham.models.employee.Employee;
import com.khoapham.models.facility.Facility;
import com.khoapham.service.IContractService;
import com.khoapham.service.ICustomerService;
import com.khoapham.service.IEmployeeService;
import com.khoapham.service.IFacilityService;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("contracts")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IFacilityService iFacilityService;

    @ModelAttribute("employees")
    public List<Employee> getAllEmployee() {
        return this.iEmployeeService.findAll();
    }

    @ModelAttribute("customers")
    public List<Customer> getAllCustomer() {
        return this.iCustomerService.findAll();
    }

    @ModelAttribute("facilities")
    public List<Facility> getAllFacility() {
        return this.iFacilityService.findAll();
    }

    @GetMapping("")
    public String goListCustomers(Model model,
                                  @RequestParam Optional<LocalDate> fromDate,
                                  @RequestParam Optional<LocalDate> toDate,
                                  @PageableDefault(value = 5) Pageable pageable) {
        LocalDate fromDateVal = fromDate.orElse(null);
        LocalDate toDateVal = toDate.orElse(null);
        Page<Contract> contracts = this.iContractService.findAll(fromDateVal, toDateVal, pageable);
        model.addAttribute("contracts", contracts);
        model.addAttribute("fromDateVal", fromDateVal);
        model.addAttribute("toDateVal", toDateVal);
        return "/contracts/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "/contracts/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated ContractDto contractDto,
                       BindingResult bindingResult,
                       Model model) {

        new ContractDto().validate(contractDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("contractDto", contractDto);
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            iContractService.save(contract);
            model.addAttribute("contractDto", new ContractDto());
            model.addAttribute("success", "Create contract successfully!");
        }
        return "/contracts/create";
    }

}
