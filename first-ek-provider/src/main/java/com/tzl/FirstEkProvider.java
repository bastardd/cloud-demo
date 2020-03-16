package com.tzl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FirstEkProvider {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FirstEkProvider.class).run(args);
    }
}
