package com.example.uums.provider.controller;

import com.mongacloud.uums.client.feign.SysUserClient;
import com.mongacloud.uums.common.base.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhigang.peng
 * @date 2021/4/28
 */
//@RestController
public class UUmsController {

//    @Autowired
    private SysUserClient sysUserClient;

//    @GetMapping("/test/{id}")
    public String test(@PathVariable String id) {
        R user = sysUserClient.getUser(id);
        return user.toString();
    }
}
