package com.example.uums.provider;

import com.example.uums.provider.service.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableFeignClients(basePackages = "com.mongacloud.uums.client.**")
@SpringBootApplication
@EnableTransactionManagement
public class UumsProviderApplication {


    @Autowired
    private Printer printer;

    public static void main(String[] args) {
        SpringApplication.run(UumsProviderApplication.class, args);
    }

}
