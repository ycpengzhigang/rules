package com.example.uums.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.uums.provider.mapper.TestUserMapper;
import com.example.uums.provider.model.TestUser;
import com.example.uums.provider.service.TestUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhigang.peng
 * @since 2021-05-13
 */
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements TestUserService {

    @Override
    public void insertSysUser() {
        TestUser testUser = new TestUser();
        testUser.setAge(12);
        testUser.setEmail("ycpengzhigang@163.com");
        testUser.setName("zhigang");
        baseMapper.insert(testUser);
        updateSysUser();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysUser() {
        TestUser testUser = new TestUser();
        testUser.setAge(30);
        testUser.setEmail("ycpengzhigang@163.com");
        testUser.setName("zhigang");
        baseMapper.update(testUser, new LambdaUpdateWrapper<TestUser>().eq(TestUser::getName, testUser.getName()));


        TestUser testUser1 = new TestUser();
        testUser.setAge(100);
        testUser.setEmail("ycpengzhigang@163.com");
        testUser.setName("pengli");
        baseMapper.insert(testUser1);

//        throw new RuntimeException("抛出异常");

    }

}
