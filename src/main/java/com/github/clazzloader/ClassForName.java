package com.github.clazzloader;

/**
 * Author: fengchen.zsx
 * date: 2018/7/19 19:08
 */
public class ClassForName {
    public void cfn() {
        System.out.println(this.getClass().getClassLoader() + " loaded ClassForName");
    }
}
