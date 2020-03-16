package com.tzl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@RestController
public class InvokerController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping(value = "/router")
    public String router(){
        String json = restTemplate.getForObject("http://first-ek-provider/person/1",String.class);
        return json;
    }

}
