package com.github.aop.javassist;

import java.lang.reflect.Method;

/**
 * Author: fengchen.zsx
 * date: 2018/8/15 16:11
 */
public class Run {
    public static void main(String[] args) {
        args = new String[]{"D"};
        Run r = new Run();
        r.sayLoder();
        if (args.length >= 1) {
            try {
                // load the target class to be run
                Class clas = Run.class.getClassLoader().loadClass(args[0]);
                // invoke "main" method of target class
                Class[] ptypes = new Class[]{args.getClass()};
                Method main = clas.getDeclaredMethod("main", ptypes);

                String[] pargs = new String[args.length - 1];
                System.arraycopy(args, 1, pargs, 0, pargs.length);

                main.invoke(null, new Object[]{pargs});

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Usage: Run main-class args...");
        }
    }

    public void sayLoder() {
        System.out.println("I'm Run I'm loaded by" + this.getClass().getClassLoader().toString());
    }
}
