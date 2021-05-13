package com.example.uums.provider.service.impl;

import com.example.uums.provider.model.TestUser;
import com.example.uums.provider.mapper.TestUserMapper;
import com.example.uums.provider.service.TestUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhigang.peng
 * @since 2021-05-13
 */
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements TestUserService {

}
