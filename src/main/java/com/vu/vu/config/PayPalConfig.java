package com.vu.vu.config;

import com.paypal.base.rest.APIContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PayPalConfig {

    @Value("${paypal.client-id}")
    private  String CientId;

    @Value("${paypal.client-sercrate}")
    private  String clientSecrate;

    @Value("${paypal.mode}")
    private  String mode;


//    @Bean
//    public   APIContext apiContext(){
//
//    }

}
