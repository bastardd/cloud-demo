package com.tzl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
public class FirstEkProvider {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(FirstEkProvider.class).properties("server.port=" + port).run(args);
    }
}
