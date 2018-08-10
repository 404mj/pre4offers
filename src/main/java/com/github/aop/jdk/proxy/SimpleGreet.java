package com.github.aop.jdk.proxy;

/**
 * Author: fengchen.zsx
 * date: 2018/8/10 18:44
 */
public class SimpleGreet implements IGreeter {

//    Logger logger = Logger.getLogger(String.valueOf(getClass()));

    /**
     * 向name打招呼
     *
     * @param name
     */
    @Override
    public void greet(String name) {
        System.out.println("Hi " + name + "~ This is SimpleGreet, I'll do the right thing");
    }
}
