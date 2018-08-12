package com.github.aop.javassist;

import javassist.ClassPool;
import javassist.Loader;

/**
 * Author: fengchen.zsx
 * date: 2018/8/10 23:51
 */
public class TestJavassistMain {
    public static void main(String[] args) throws Throwable {
        //获取存放CtClass的容器ClassPool
        ClassPool cp = ClassPool.getDefault();
        //创建一个类加载器
        Loader cl = new Loader();
        //增加一个转换器
        cl.addTranslator(cp, new JavassistAdvice());

        cl.run("com.github.aop.javassist.JavassistAdvice", args);
    }
}
