package com.trio.assignment.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
@EnableFeignClients(basePackages = {
    "com.trio.assignment.feign"
})
public class FeignConfiguration {

    @Bean
    public feign.Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}