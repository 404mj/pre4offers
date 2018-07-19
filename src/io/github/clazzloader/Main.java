package io.github.clazzloader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Map;

/**
 * Author: fengchen.zsx
 * date: 2018/7/19 19:08
 */
public class Main {
    public void m() throws Exception {
        System.out.println(this.getClass().getClassLoader() + " loaded Main");

        // Java loaded
        JavaLoaded javaLoaded = new JavaLoaded();
        javaLoaded.jl();

        // Class.forName
        Class<?> classForName = Class.forName("io.github.clazzloader.ClassForName");
        classForName.getMethod("cm", new Class[]{}).invoke(classForName.newInstance(), new Object[]{});

        // ClassLoader.loadClass
        Class<?> loadClass = Main.class.getClassLoader().loadClass("io.github.clazzloader.LoadClass");
        loadClass.getMethod("lm", new Class[]{}).invoke(loadClass.newInstance(), new Object[]{});
    }

    public void loadedClass() throws Exception {
        CachedClassLoader j1 = new CachedClassLoader(new URL[]{new File(
                "/Users/zsx/worksapce/pre4offers/out/artifacts/pre4offers-1.0-SNAPSHOT.jar").toURI().toURL()});
        j1.setName("1#");
        CachedClassLoader j2 = new CachedClassLoader(new URL[]{new File(
                "/Users/zsx/worksapce/pre4offers/out/artifacts/pre4offers-1.0-SNAPSHOT.jar").toURI().toURL()});
        j2.setName("2#");

        j1.injectClass("io.github.clazzloader.JavaLoaded", j2.loadClass("io.github.clazzloader.JavaLoaded"));
        j1.injectClass("io.github.clazzloader.ClassForName", j2.loadClass("io.github.clazzloader.ClassForName"));
        j1.injectClass("io.github.clazzloader.LoadClass", j2.loadClass("io.github.clazzloader.LoadClass"));

        Class<?> a1 = j1.loadClass("io.github.clazzloader.Main");

        Method aM = a1.getMethod("m", new Class<?>[]{});
        aM.invoke(a1.newInstance(), new Object[]{});

        System.out.println("1# findLoaded.");

        System.out.println(j1.findLoadedClass1("io.github.clazzloader.JavaLoaded")); // √
        System.out.println(j1.findLoadedClass1("io.github.clazzloader.ClassForName")); // √
        System.out.println(j1.findLoadedClass1("io.github.clazzloader.LoadClass")); // x

        System.out.println("2# findLoaded.");

        System.out.println(j2.findLoadedClass1("io.github.clazzloader.JavaLoaded")); // √
        System.out.println(j2.findLoadedClass1("io.github.clazzloader.ClassForName")); // √
        System.out.println(j2.findLoadedClass1("io.github.clazzloader.LoadClass")); // √
    }

    public static void main(String[] args) {
        Main m = new Main();
        try {
            m.loadedClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
