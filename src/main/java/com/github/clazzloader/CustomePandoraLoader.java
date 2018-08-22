package com.github.clazzloader;

import java.io.FileInputStream;

/**
 * Author: fengchen.zsx
 * date: 2018/8/20 13:42
 */
public class CustomePandoraLoader extends ClassLoader {
    private String classPath;

    public CustomePandoraLoader(String classPath) {
        this.classPath = classPath;
    }

    /**
     * 加载指定类的字节码
     */
    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name
                + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }
}
