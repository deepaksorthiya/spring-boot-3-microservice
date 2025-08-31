package com.example.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class HttpClientConfig {

    @LoadBalanced
    @Bean
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    RestClient.Builder loadBalancedRestClientBuilder() {
        return RestClient.builder();
    }

    @Primary
    @Bean
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }

    @LoadBalanced
    @Bean
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
    WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    @Primary
    @Bean
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
    WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
