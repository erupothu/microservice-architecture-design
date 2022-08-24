package com.example.student.controller;

// import com.example.student.config.CustomPropertiesConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentPropertesController {
    
    @Value("${spring.application: eswar}")
    String testing;

    @Autowired
    Environment env;

    // @Autowired
    // CustomPropertiesConfig customPropConfig;

    @GetMapping("get-application-name-env")
    public String getApplicationNameByEnv() {

        return env.getProperty("message");
    }

    @GetMapping("get-application-name-value")
    public String getApplicationNameByValue() {

        return testing;
    }

    // @GetMapping("get-custom-message")
    // public String getCustomMessage() {

    //     return customPropConfig.getCustomMessage();
    // }
}
