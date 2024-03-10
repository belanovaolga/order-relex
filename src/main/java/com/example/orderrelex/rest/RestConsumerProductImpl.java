package com.example.orderrelex.rest;

import com.example.orderrelex.dto.ProductCountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * класс для общения с микросервисом Product
 */
@Component
@RequiredArgsConstructor
public class RestConsumerProductImpl implements RestConsumerProduct {
    private final RestTemplate restTemplate;

    @Value("${spring.service-url}")
    private String serviceUrl;

    @Value("${service.urlAdd}")
    private String endUrl;

    @Override
    public void setProductCount(ProductCountDto product) {
        String resourceUrl = serviceUrl + endUrl;

        restTemplate.postForObject(resourceUrl, product, ProductCountDto.class);
    }
}
