package com.arvin.mq.arvinmq.test;

public class Test {
    public Test() {}
    private final static Test instance = new Test();
    public static Test getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(Test.getInstance());
        System.out.println(Test.getInstance());
    }
}
