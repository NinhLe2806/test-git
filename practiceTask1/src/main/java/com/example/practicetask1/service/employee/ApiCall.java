package com.example.practicetask1.service.employee;

import com.example.practicetask1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ApiCall {
    @Autowired
    private RestTemplate restTemplate;

    private static final String productMicroserviceBaseURL =
            "http://product-service";

    public Product getProductDetails(long productId) {
        Product product = restTemplate.getForObject(
                productMicroserviceBaseURL + "/product/id?id={productId}",
                Product.class, productId);
        return product;
    }
}
