package com.example.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class WebClientTestController {
    private final WebClient.Builder webClient;
    private final DiscoveryClient discoveryClient;

    public WebClientTestController(WebClient.Builder webClient, DiscoveryClient discoveryClient) {
        this.webClient = webClient;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @GetMapping("/service-instances")
    public List<String> serviceAllInstances() {
        return this.discoveryClient.getServices();
    }

    @GetMapping("/webclient/test")
    public Mono<String> getServiceOneMessage() {
        return webClient.build().get().uri("lb://SERVICE-ONE/secure").retrieve().bodyToMono(String.class);
    }
}


