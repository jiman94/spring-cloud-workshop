package com.skplanet.display.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductRemoteServiceImp implements ProductRemoteService {

    private final String url = "http://localhost:8082/products/";

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand
    public String getProductInfo(String productId) {
        return this.restTemplate.getForObject(url + productId, String.class);
    }
}