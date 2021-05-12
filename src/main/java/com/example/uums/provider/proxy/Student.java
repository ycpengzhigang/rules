package com.example.uums.provider.proxy;

/**
 * @author zhigang.peng
 * @date 2021/5/12
 */
public class Student implements StudyCapatable {

    private String name;

    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:" + name + "," + "age:" + age;
    }

    @Override
    public void study() {
        System.out.println(name + ":学习中");
    }

    @Override
    public void play() {
        System.out.println("玩耍中");
    }
}
