package com.example.uums.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableFeignClients(basePackages = "com.mongacloud.uums.client.**")
@SpringBootApplication
@EnableTransactionManagement
public class UumsProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(UumsProviderApplication.class, args);
    }

}
