package com.khoapham.controller;

import com.khoapham.model.Product;
import com.khoapham.model.ProductType;
import com.khoapham.service.IOrderService;
import com.khoapham.service.IProductService;
import com.khoapham.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/order-res")
public class OrderResController {
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductTypeService iProductTypeService;

    @ModelAttribute("products")
    public List<Product> getAllProduct() {
        return this.iProductService.findAll();
    }

    @ModelAttribute("productTypes")
    public List<ProductType> getAllProductType() {
        return this.iProductTypeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Product>> getProductByProductType(@PathVariable Integer id) {
        ProductType productType = iProductTypeService.findById(id);

        if (productType == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Product> productList = this.iProductService.findByProductType(productType);

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

}
