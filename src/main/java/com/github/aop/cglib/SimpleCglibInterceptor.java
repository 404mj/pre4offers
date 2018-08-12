package com.github.aop.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author: fengchen.zsx
 * date: 2018/8/10 22:36
 * <p>
 * 使用包装了asm的cglib
 * 实现代理织入逻辑。
 */
public class SimpleCglibInterceptor implements MethodInterceptor {

    /**
     * @param o           被代理对象
     * @param method      被拦截的方法，需要增强的方法
     * @param args        方法参数们
     * @param methodProxy cglib提供的被拦截方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before invoke " + method);

        Object result = methodProxy.invokeSuper(o, args);
//        Object result = method.invoke(o, args); // ERROR!use this!

        System.out.println("After invoke" + method);

        return result;
    }
}
