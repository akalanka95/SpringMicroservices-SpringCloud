package com.akalanka.springmicroservice.limitservice.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Configuration {

    private int minimum;
    private int maximum;

}
