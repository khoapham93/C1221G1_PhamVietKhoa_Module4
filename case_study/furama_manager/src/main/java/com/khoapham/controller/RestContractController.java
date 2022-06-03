package com.khoapham.controller;

import com.khoapham.dto.ServiceAttachInContract;
import com.khoapham.exception.ObjectNotFound;
import com.khoapham.models.facility.Facility;
import com.khoapham.service.IContractService;
import com.khoapham.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/contractRes")
public class RestContractController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IContractService iContractService;

    @GetMapping("/{id}")
    public ResponseEntity<Facility> find(@PathVariable Integer id) throws ObjectNotFound {
        Facility facilityRes = iFacilityService.findById(id);
        if (facilityRes == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(facilityRes, HttpStatus.OK);
    }

    @GetMapping("/{id}/showDetails")
    public ResponseEntity<List<ServiceAttachInContract>> showDetail(@PathVariable Integer id) throws ObjectNotFound {
        List<ServiceAttachInContract> detailByContractId = iContractService.findDetailByContractId(id);
        if (detailByContractId == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(detailByContractId, HttpStatus.OK);
    }

    @ExceptionHandler(ObjectNotFound.class)
    public ModelAndView showNotFoundPage() {
        return new ModelAndView("notFound");
    }
}
