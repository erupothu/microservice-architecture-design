package com.example.consulserver.controller;

import com.example.consulserver.config.MyProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistributedPropertiesController {
    
    @Value("${application.name: defaultName}")
    String appName;

    @Autowired
    Environment env;



    @Autowired
    private MyProperties properties;

    // @GetMapping("/getConfigFromValue")
    // public String getConfigFromValue() {
    //     return value;
    // }

    @GetMapping("/getConfigFromProperty")
    public String getConfigFromProperty() {
        System.out.println(env.getProperty("application.name"));
        return properties.getProp();
    }
}
