package com.khoapham.controller;

import com.khoapham.models.facility.Facility;
import com.khoapham.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/contractRes")
public class RestContractController {
    @Autowired
    private IFacilityService iFacilityService;

    @GetMapping("/{id}")
    public ResponseEntity<Facility> find(@PathVariable Integer id) {
        Facility facilityRes = iFacilityService.findById(id);
        if (facilityRes == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(facilityRes, HttpStatus.OK);
    }
}
