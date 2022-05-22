package com.khoapham.controller;

import com.khoapham.models.*;
import com.khoapham.service.IFacilityService;
import com.khoapham.service.IFacilityTypeService;
import com.khoapham.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
