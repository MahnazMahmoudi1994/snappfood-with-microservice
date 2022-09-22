package com.kurdestanbootcamp.basketitemservice.common.config;

import com.kurdestanbootcamp.basketitemservice.common.exception.CustomApiErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomApiErrorDecoder();
    }
}