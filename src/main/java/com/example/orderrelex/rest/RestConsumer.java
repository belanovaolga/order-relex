package com.example.orderrelex.rest;

import com.example.orderrelex.dto.ProductCountDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * класс для общения с микросервисом Product
 */
@Component
public class RestConsumer {
    RestTemplate restTemplate = new RestTemplate();

    public void setProductCount(ProductCountDto product) {
        String resourceUrl = "http://localhost:8300/addProduct";

        restTemplate.postForObject(resourceUrl, product, ProductCountDto.class);
    }
}
