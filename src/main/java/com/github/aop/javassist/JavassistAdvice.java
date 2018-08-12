package com.github.aop.javassist;

import javassist.*;

/**
 * Author: fengchen.zsx
 * date: 2018/8/11 00:07
 * <p>
 * 类加载监听器， 可以理解为对被代理类进行加强的地方，
 * 所以叫advice。
 * 实现translator， 实现两个方法！
 * 其实是监听类加载
 */
public class JavassistAdvice implements Translator {

    @Override
    public void start(ClassPool classPool) throws NotFoundException, CannotCompileException {

    }

    /**
     * 当指定的类加载到JVM前进行织入
     * 增强逻辑！
     *
     * @param classPool
     * @param classname
     * @throws NotFoundException
     * @throws CannotCompileException
     */
    @Override
    public void onLoad(ClassPool classPool, String classname) throws NotFoundException, CannotCompileException {
//        System.out.println("onLoad-->" + classname);
        if (!"com.github.aop.javassist.JavassistProxied".equals(classname)) {
            return;
        }
        //通过获取类文件
        try {
            CtClass cc = classPool.get(classname);
            //获得指定方法名的方法
            CtMethod m = cc.getDeclaredMethod("doRight");
            //在方法执行前插入代码
            m.insertBefore("{ System.out.println(\"记录日志\"); }");
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JavassistProxied proxied = new JavassistProxied();
        proxied.doRight();
    }
}
