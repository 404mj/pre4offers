package com.github.aop.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: fengchen.zsx
 * date: 2018/8/10 18:51
 */
public class JdkDynamicProxy implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object subject;

    public JdkDynamicProxy(Object subject) {
        this.subject = subject;
    }

    /**
     * @param proxy  代理对象
     * @param method 被代理对象的方法
     * @param args   被代理对象的方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前执行 织入的逻辑
        System.out.println("Hi " + args[0] + " before invoke");

        // 执行原有逻辑
        Object res = method.invoke(subject, args);

        // 后执行 织入的逻辑
        System.out.println("Hi " + args[0] + " after invoke I'm Dynamic Proxy!");

        return res;
    }
}
