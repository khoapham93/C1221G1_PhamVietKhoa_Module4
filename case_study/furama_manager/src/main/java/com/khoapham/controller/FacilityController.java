package com.khoapham.controller;

import com.khoapham.dto.EmployeeDto;
import com.khoapham.dto.FacilityDto;
import com.khoapham.models.*;
import com.khoapham.service.IFacilityService;
import com.khoapham.service.IFacilityTypeService;
import com.khoapham.service.IRentTypeService;
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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facilities")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @ModelAttribute("facilityTypes")
    public List<FacilityType> findAllFacilityType() {
        return this.iFacilityTypeService.findAll();
    }

    @ModelAttribute("rentTypes")
    public List<RentType> findAllRentType() {
        return this.iRentTypeService.findAll();
    }

    @GetMapping("")
    public String goListEmployees(Model model,
                                  @RequestParam Optional<String> name,
                                  @RequestParam Optional<String> roomStandard,
                                  @RequestParam Optional<Integer> facilityType,
                                  @PageableDefault(value = 5) Pageable pageable) {
        String nameVal = name.orElse("");
        String roomStandardVal = roomStandard.orElse("");
        Integer facilityTypeVal = facilityType.orElse(-1);
        Page<Facility> facilities = this.iFacilityService.findAll(nameVal, roomStandardVal, facilityTypeVal, pageable);
        model.addAttribute("facilities", facilities);
        model.addAttribute("nameVal", nameVal);
        model.addAttribute("roomStandardVal", roomStandardVal);
        model.addAttribute("facilityTypeVal", facilityTypeVal);
        return "/facilities/list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        return "/facilities/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated FacilityDto facilityDto,
                       BindingResult bindingResult,
                       Model model) {

        new FacilityDto().validate(facilityDto, bindingResult);
        this.iFacilityService.checkExists(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityDto", facilityDto);
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            iFacilityService.save(facility);
            model.addAttribute("facilityDto", new FacilityDto());
            model.addAttribute("success", "Create facility successfully!");
        }
        return "/facilities/create";
    }
}
