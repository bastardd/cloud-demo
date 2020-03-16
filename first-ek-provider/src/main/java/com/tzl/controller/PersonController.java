package com.tzl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PersonController {

    @GetMapping("/person/{personId}")
    public Map<String,Object> getPerson(@PathVariable(value = "personId") String personId){
        Map<String,Object> map = new HashMap<>();
        map.put("personName","张三");
        map.put("personId",personId);
        return map;
    }
}
