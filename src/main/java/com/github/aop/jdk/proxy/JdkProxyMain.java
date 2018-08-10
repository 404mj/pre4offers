package com.github.aop.jdk.proxy;

import java.lang.reflect.Proxy;

/**
 * Author: fengchen.zsx
 * date: 2018/8/10 19:03
 */
public class JdkProxyMain {
    public static void main(String[] args) {

        //需要代理的接口，被代理类实现的多个接口都必须在这里定义
        Class[] proxyInterfaces = new Class[]{IGreeter.class};
        //构建AOP的Advice，这里需要传入业务类的实例
        JdkDynamicProxy handler = new JdkDynamicProxy(new SimpleGreet());
        //生成代理类的字节码加载器
        ClassLoader classLoader = JdkProxyMain.class.getClassLoader();

        //织入器，织入代码并生成代理类
        IGreeter proxy = (IGreeter) Proxy.newProxyInstance(classLoader, proxyInterfaces, handler);

        //使用代理类的实例来调用方法。
        proxy.greet("ZSX");
    }
}
