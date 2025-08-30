package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;


@Configuration
public class GatewayRouteConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(GatewayRouteConfiguration.class);

    @Bean
    public RouteLocator discoveryRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/get")
                        .filters(f -> f
                                //.addResponseHeader("X-API-VERSION", "v1.0.0")
                                //.addRequestHeader("X-API-VERSION", "v1.0.0")
                                .filter((exchange, chain) -> {
                                    LOGGER.info("Received request :: {}", exchange.getRequest().getPath());
                                    ServerHttpRequest request = exchange.getRequest()
                                            .mutate()
                                            .headers(httpHeaders -> httpHeaders.add("X-API-VERSION", "v1.0.0"))
                                            .build();
                                    // make sure response is not committed
                                    ServerHttpResponse response = exchange.getResponse();
                                    response.getHeaders().set("X-API-VERSION", "v1.0.0");
                                    return chain.filter(exchange.mutate().request(request).build());
                                }))
                        .uri("https://httpbin.org/get"))
                .build();
    }
}
