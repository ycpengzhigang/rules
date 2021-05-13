package com.example.uums.provider;

import com.example.uums.provider.service.TestUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UumsProviderApplicationTests {


    @Autowired
    TestUserService testUserService;

    void contextLoads() {
    }

    @Test
    public void testTransaction() {
        testUserService.insertSysUser();
    }

}
