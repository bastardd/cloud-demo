package com.tzl.controller;

import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * 在服务调用者的控制器中，服务中调用RestTemplate
 */
@RestController
public class InvokerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private SpringClientFactory factory;


    @GetMapping(value = "/router")
    public String router(){
        String json = restTemplate.getForObject("http://first-ek-provider/person/1",String.class);
        return json;
    }

    @GetMapping(value = "/useIB")
    public ServiceInstance userIB(){
        //查找服务器实例
        return loadBalancerClient.choose("first-ek-provider");
    }

    @RequestMapping(value = "/defaultValue")
    public String defaultValue(){
        System.out.println("---输出默认的配置-------");
        //获取默认配置
        ZoneAwareLoadBalancer ab = (ZoneAwareLoadBalancer)factory.getLoadBalancer("default");
        System.out.println("  IClientConfig: " + factory.getLoadBalancer("default").getClass().getName());
        System.out.println("  IRule: " + ab.getRule().getClass().getName());
        System.out.println("  IPing：" + ab.getPing().getClass().getName());
        System.out.println("  ServerList :" + ab.getServerListImpl().getClass().getName());
        System.out.println("  ServerFilter : "+ ab.getFilter().getClass().getName());
        System.out.println("  ILoadBalancer :" + ab.getClass().getName());
        System.out.println("  PingInterval : " + ab.getPingInterval());
        System.out.println("--------输出 first-ek-provider 的配置");
        ZoneAwareLoadBalancer providerab = (ZoneAwareLoadBalancer)factory.getLoadBalancer("first-ek-provider");
        System.out.println("  IClientConfig: " + factory.getLoadBalancer("first-ek-provider").getClass().getName());
        System.out.println("  IRule: " + providerab.getRule().getClass().getName());
        System.out.println("  IPing：" + providerab.getPing().getClass().getName());
        System.out.println("  ServerList :" + providerab.getServerListImpl().getClass().getName());
        System.out.println("  ServerFilter : "+ providerab.getFilter().getClass().getName());
        System.out.println("  ILoadBalancer :" + providerab.getClass().getName());
        System.out.println("  PingInterval : " + providerab.getPingInterval());
        return "";
    }

}
