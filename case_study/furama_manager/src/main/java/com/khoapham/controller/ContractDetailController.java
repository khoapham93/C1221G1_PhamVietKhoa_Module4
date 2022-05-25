package com.khoapham.controller;

import com.khoapham.dto.ContractDetailDto;
import com.khoapham.models.contract.Contract;
import com.khoapham.models.contract.ContractDetail;
import com.khoapham.models.contract.ServiceInclude;
import com.khoapham.service.IContractDetailService;
import com.khoapham.service.IContractService;
import com.khoapham.service.IServiceIncludeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/contract-details")
public class ContractDetailController {

    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IServiceIncludeService iServiceIncludeService;
    @Autowired
    private IContractService iContractService;

    @ModelAttribute("contracts")
    public List<Contract> findAllContract() {
        return this.iContractService.findAll();
    }

    @ModelAttribute("serviceIncludes")
    public List<ServiceInclude> findAllServiceInclude() {
        return this.iServiceIncludeService.findAll();
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "/contracts/createContractDetail";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated ContractDetailDto contractDetailDto,
                       BindingResult bindingResult,
                       Model model) {

        new ContractDetailDto().validate(contractDetailDto, bindingResult);
        this.iContractDetailService.checkExists(contractDetailDto, bindingResult);
        if (bindingResult.hasErrors()) {

            model.addAttribute("contractDetailDto", contractDetailDto);
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);

            iContractDetailService.save(contractDetail);

            model.addAttribute("contractDetailDto", new ContractDetailDto());
            model.addAttribute("success", "Create contractDetail successfully!");
        }
        return "/contracts/createContractDetail";
    }

}
