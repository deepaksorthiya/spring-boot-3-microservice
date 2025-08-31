package com.example.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
@RestController
public class WebClientTestController {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public WebClientTestController(@LoadBalanced WebClient.Builder loadBalancedWebClientBuilder) {
        this.loadBalancedWebClientBuilder = loadBalancedWebClientBuilder;
    }

    @GetMapping("/webclient/test")
    public Mono<ResponseEntity<String>> getServiceOneMessageUsingWebClient() {
        return loadBalancedWebClientBuilder.build().get().uri("lb://SERVICE-ONE/secure").retrieve().toEntity(String.class);
    }
}


