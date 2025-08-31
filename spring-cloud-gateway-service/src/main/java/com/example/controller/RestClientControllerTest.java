package com.example.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@RestController
public class RestClientControllerTest {
    private final RestClient.Builder loadBalancedRestClientBuilder;

    public RestClientControllerTest(@LoadBalanced RestClient.Builder loadBalancedRestClientBuilder) {
        this.loadBalancedRestClientBuilder = loadBalancedRestClientBuilder;
    }

    @GetMapping("/restclient/test")
    public ResponseEntity<String> getServiceOneMessageUsingRestClient() {
        ResponseEntity<String> response = loadBalancedRestClientBuilder.build().get().uri("lb://SERVICE-ONE/secure").retrieve().toEntity(String.class);
        return response;
    }
}

