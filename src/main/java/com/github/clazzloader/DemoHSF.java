package com.github.clazzloader;

/**
 * Author: fengchen.zsx
 * date: 2018/8/20 13:44
 */
public class DemoHSF {
    public void rpc(Integer var1, String var2) {
        System.out.println(String.format("i'm hsf rpc, invoke by classloader : %s , var1 = %s var2 = %s", getClass().getClassLoader().getClass(), var1, var2));
        ClassLoader loader = DemoHSF.class.getClassLoader();
        while (loader != null) {
            System.out.println("tair parent classloader : " + loader);
            loader = loader.getParent();
        }
        System.out.println("tair parent classloader : " + loader + "\n");
    }
}
