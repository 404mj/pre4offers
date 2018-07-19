package io.github.clazzloader;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: fengchen.zsx
 * date: 2018/7/19 19:11
 */
public class CachedClassLoader extends URLClassLoader {

    private final Map<String, Class<?>> CACHE = new ConcurrentHashMap<>();

    private String name;

    public CachedClassLoader(URL[] urls) {
        super(urls, null);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> clazz = CACHE.get(name);
        if (clazz != null) {
            return clazz;
        }
        return super.loadClass(name);
    }

    public Class<?> defineClassFromFile(String name, byte[] bytes) {
        return defineClass(name, bytes, 0, bytes.length);
    }

    /**
     * 将class类名和实例放到cache中
     *
     * @param name
     * @param clazz
     */
    public final void injectClass(String name, Class<?> clazz) {
        if (name != null && clazz != null) {
            CACHE.put(name, clazz);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public Class<?> findLoadedClass1(final String name) {
        return this.findLoadedClass(name);
    }
}
