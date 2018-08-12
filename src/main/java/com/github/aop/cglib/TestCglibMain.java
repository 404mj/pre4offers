package com.github.aop.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Author: fengchen.zsx
 * date: 2018/8/10 22:34
 */
public class TestCglibMain {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(SimpleProxied.class);        //  设置被代理类！

        enhancer.setCallback(new SimpleCglibInterceptor());// 设置代理类

        SimpleProxied proxied = (SimpleProxied) enhancer.create();

        proxied.greet("zsx");
    }
}
