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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/{id}/create")
    public String create(@PathVariable Integer id, Model model) {
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        contractDetailDto.setContract(this.iContractService.findById(id));
        model.addAttribute("contractDetailDto", contractDetailDto);
        return "/contracts/createContractDetail";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated ContractDetailDto contractDetailDto,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirect) {
        new ContractDetailDto().validate(contractDetailDto, bindingResult);
        this.iContractDetailService.checkExists(contractDetailDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractDetailDto", contractDetailDto);
            return "/contracts/createContractDetail";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            iContractDetailService.save(contractDetail);
            redirect.addFlashAttribute("success", "Create contractDetail successfully!");
            return "redirect:/contracts/list";
        }
    }

}
