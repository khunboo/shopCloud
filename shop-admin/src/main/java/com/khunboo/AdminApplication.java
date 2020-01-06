package com.khunboo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.khunboo"})
public class AdminApplication {

    public static void main(String[] args){
        SpringApplication.run(AdminApplication.class, args);
    }
}
