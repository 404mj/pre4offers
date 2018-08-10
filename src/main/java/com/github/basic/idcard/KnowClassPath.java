package com.github.basic.idcard;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by zsx at 18-5-4 下午4:50
 */
public class KnowClassPath {
    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader)cl).getURLs();
        for(URL url: urls){
            System.out.println(url.getFile());
        }
    }
}
