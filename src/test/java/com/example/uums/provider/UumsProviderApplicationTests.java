package com.example.uums.provider;

import com.example.uums.provider.service.Printer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UumsProviderApplicationTests {

    @Autowired
    private Printer printer;

    void contextLoads() {
    }

    @Test
    public void testTransaction() {
        printer.print();
    }

}
