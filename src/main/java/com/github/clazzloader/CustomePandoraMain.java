package com.github.clazzloader;

/**
 * Author: fengchen.zsx
 * date: 2018/8/20 13:46
 */
public class CustomePandoraMain {
    /**
     *
     */
    public static void main(String[] args) throws ClassNotFoundException {
        String classPath = "/Users/zsx/worksapce/pre4offers/src/main/java/com/github/clazzloader/";

        //classloader hsf
        CustomePandoraLoader hsfClassLoader = new CustomePandoraLoader(classPath);
        Class hsfClazz = hsfClassLoader.loadClass("com.github.clazzloader.DemoHSF");

        CustomePandoraLoader hsfClassLoader2 = new CustomePandoraLoader(classPath);
        Class hsfClazz2 = hsfClassLoader2.loadClass("com.github.clazzloader.DemoHSF");

        try {
            Object hsfObj = hsfClazz.newInstance();

            Object hsfObj1 = hsfClazz.newInstance();
            Object hsfObj2 = hsfClazz2.newInstance();

            System.out.println("pause...");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
