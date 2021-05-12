package com.example.uums.provider.proxy;

import java.lang.reflect.Proxy;

/**
 * @author zhigang.peng
 * @date 2021/5/12
 */
public class JdkProxy {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        StudyCapatable student = new Student("志刚", 24);

        StudentPlay studentPlay = new StudentPlay(student);

        StudyCapatable studyCapatable = (StudyCapatable) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                student.getClass().getInterfaces(),
                studentPlay);

        studyCapatable.study();

    }


}
