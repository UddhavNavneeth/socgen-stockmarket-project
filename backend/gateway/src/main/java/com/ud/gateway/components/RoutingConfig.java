package com.ud.gateway.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {


        return builder.routes()
                .route(r -> r.path("/user/**")
                        //Pre and Post Filters provided by Spring Cloud Gateway
//                        .filters(f -> f.filter(new SimpleFilter()))
                        .uri("http://localhost:8086"))


                .route(r -> r.path("/consumer/**")
//                        //Pre and Post Filters provided by Spring Cloud Gateway
//                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
//                                .addResponseHeader("second-response", "second-response-header"))
                        .uri("http://localhost:8082/")
                        .id("consumerModule"))
                .build();
    }

}
