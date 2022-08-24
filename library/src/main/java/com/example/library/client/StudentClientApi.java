package com.example.library.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "student")
public interface StudentClientApi {

    @GetMapping("swelcome")
    public String welcome();
    
}
