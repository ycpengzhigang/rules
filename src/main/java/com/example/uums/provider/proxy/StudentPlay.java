package com.example.uums.provider.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhigang.peng
 * @date 2021/5/12
 * @see InvocationHandler
 */
public class StudentPlay implements InvocationHandler {

    private StudyCapatable student;

    public StudentPlay(StudyCapatable student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始玩游戏");
        Object obj = method.invoke(student);
        System.out.println("学习完了");
        return obj;
    }

}
