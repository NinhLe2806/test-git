package com.example.practicetask1.service.employee;


import com.example.practicetask1.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service", url ="http://localhost:8763")
public interface FeignService {

    @GetMapping("/product/id?id={productId}")
    public Product findProductById(@RequestParam(value = "id") long id);
}
