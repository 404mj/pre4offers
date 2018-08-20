package com.github.aop.javassist;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Author: fengchen.zsx
 * date: 2018/8/15 16:23
 * <p>
 * NOTE: ****要是查看效果应该独立命令行运行！***
 * ref: https://www.ibm.com/developerworks/cn/java/j-dyn0203/
 */
public class VerboseLoader extends URLClassLoader {
    protected VerboseLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public Class loadClass(String name)
            throws ClassNotFoundException {
        System.out.println("加载类loadClass: " + name);
        return super.loadClass(name);
    }

    /**
     * The base class method implements the standard classloader delegation behavior,
     * first checking if the parent classloader can load the requested class.
     * <p>
     * and only trying to load the class directly using the protected findClass() method if the parent classloader fails.
     * <p>
     * 在这个例子中，运行后发现只有Run是由目前这个VerboseLoader加载的。Run使用的Object，Throwable，String等都由loadClass()方法调用的时候委托
     * 给父Loader执行了。只有当父类加载不到，才会调用当前的findClass()方法， 实际也是这样的，findClass植被调用了一次！加载了Run。
     * <p>
     * 按照JVM类加载器的架构，我们的VerboseLoader的位置是这样的：
     * Bootstrap
     * |
     * System
     * /          \
     * Application  VerboseLoader
     * 他取代了app loader的作用，代替他来加载用户类。
     */
    protected Class findClass(String name)
            throws ClassNotFoundException {
        Class clas = super.findClass(name);
        System.out.println("寻找类findclass: loaded " + name + " from this loader" + this.getClass().getClassLoader());
        return clas;
    }

    public static void main(String[] args) {
        args = new String[]{"Run"};
        if (args.length >= 1) {
            try {
                // get paths to be used for loading
                ClassLoader sysLoader = ClassLoader.getSystemClassLoader();
                URL[] urls;
                if (sysLoader instanceof URLClassLoader) {
                    System.out.println("is instanceOf URLClassLoader");
                    urls = ((URLClassLoader) sysLoader).getURLs();
                } else {
                    urls = new URL[]{new File(".").toURI().toURL()};
                }

                // list the paths actually being used
                System.out.println("默认从下面路径加载类Loading from paths:");
                for (int i = 0; i < urls.length; i++) {
                    System.out.println(" " + urls[i]);
                }

                // load target class using custom class loader,加载参数指定的类，使用这个自定义的VerboseClassLoader
                VerboseLoader loader = new VerboseLoader(urls, sysLoader.getParent());
                Class runClass = loader.loadClass(args[0]);

                /**
                 * NOTE：注意这行！设置ContextClassLoader，才实现了上面说的让VerboseLoader加载Run！！
                 */
                Thread.currentThread().setContextClassLoader(loader);

                // invoke "main" method of target class
                Class[] argClass = new Class[]{args.getClass()};
                Method main = runClass.getDeclaredMethod("main", argClass);

                String[] argVals = new String[args.length - 1];
                System.arraycopy(args, 1, argVals, 0, argVals.length);

                main.invoke(null, new Object[]{argVals});

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println
                    ("Usage: VerboseLoader main-class args...");
        }
    }
}
