package com.khoapham.controller;

import com.khoapham.model.Category;
import com.khoapham.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/categoriesRest")
@RestController
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategoriesList() {
        List<Category> categories = this.iCategoryService.findAll();

        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
