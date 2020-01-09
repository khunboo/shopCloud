package com.khunboo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GateWayApplication {

    public static void main(String[] args){
        SpringApplication.run(GateWayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){

        return builder.routes()
                .route("shop-admin", r -> r.path("/shop/admin/**").uri("lb://SHOP-ADMIN")).build();
    }
}
