package com.example.uums.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.uums.provider.model.TestUser;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhigang.peng
 * @since 2021-05-13
 */
public interface TestUserService extends IService<TestUser> {


    void insertSysUser();

    void updateSysUser();


}
