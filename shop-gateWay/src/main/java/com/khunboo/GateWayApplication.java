package com.khunboo;

import com.khunboo.filter.AuthGateWayFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class GateWayApplication {

    @Autowired
    private AuthGateWayFilter authGateWayFilter;

    public static void main(String[] args){
        SpringApplication.run(GateWayApplication.class, args);
    }

    /**
     * 调用网络方法
     *
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){

        return builder.routes()
                .route("shop-admin", r -> r.path("/shop/admin/**").uri("lb://SHOP-ADMIN").filter(authGateWayFilter)).build();

    }
}
