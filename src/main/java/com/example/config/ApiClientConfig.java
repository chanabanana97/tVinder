package com.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "api")
@Data
public class ApiClientConfig {

    private String baseUrl;
    private String authToken;

}