package com.tzl.config;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.tzl.cloud.MyPing;
import com.tzl.cloud.MyRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

    @Bean
    @LoadBalanced   //开启负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule getRule(){
        return new MyRule();
    }

    @Bean
    public IPing getPing(){
        return new MyPing();
    }

}
