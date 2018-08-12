package com.github.aop.cglib;

/**
 * Author: fengchen.zsx
 * date: 2018/8/10 22:35
 * <p>
 * 简单的被代理的类
 * 可以可jdk.proxy比较使用的区别和联系
 */
public class SimpleProxied {
    /**
     * 向name问好
     */
    public void greet(String name) {
        System.out.println("Hi " + name + "I'm Proxied!");
    }
}
