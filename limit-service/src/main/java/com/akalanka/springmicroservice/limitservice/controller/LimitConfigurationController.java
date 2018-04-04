package com.akalanka.springmicroservice.limitservice.controller;

import com.akalanka.springmicroservice.limitservice.configuration.Configuration;
import com.akalanka.springmicroservice.limitservice.domain.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping(value = "/limits")
    public LimitConfiguration RetriveLimitConfiguration(){
        return new LimitConfiguration(configuration.getMinimum() , configuration.getMaximum());
    }

    @GetMapping(value = "/sample-fault-tolerance")
    @Hy
    public LimitConfiguration retriveLimitConfig(){
        throw new RuntimeException("NOt Available");
    }
}

