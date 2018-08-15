package com.github.aop.javassist;

import javassist.ClassPool;
import javassist.Loader;

/**
 * Author: fengchen.zsx
 * date: 2018/8/10 23:51
 */
public class TestJavassistMain {
    public static void main(String[] args) throws Throwable {
        /**
         * 使用系统类加载器启动我们**自定义的类加载器**，在这个类加载器里加一
         * 个类加载监听器，监听器发现目标类被加载时就织入切入逻辑
         */
        // todo: 这种方式只能拦截自定义加载器，使用Instrumentation+Javassist实现字节码转换器
        //获取存放CtClass的容器ClassPool
        ClassPool cp = ClassPool.getDefault();
        //创建一个类加载器
        Loader cl = new Loader();
        //增加一个转换器
        cl.addTranslator(cp, new JavassistAdvice());

        // 启动JavassistAdvice（类加载监听器）的main方法
        cl.run("com.github.aop.javassist.JavassistAdvice", args);
    }
}
