package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/id")
    public Product getProductById(@RequestParam(value = "id", defaultValue = "1") long id) {
        return productService.getProductById(id);
    }

    //Test
    @GetMapping("/")
    public String test(){
        return "Hello guys I am a Product";
    }


}
