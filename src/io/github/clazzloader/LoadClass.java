package io.github.clazzloader;

/**
 * Author: fengchen.zsx
 * date: 2018/7/19 19:09
 */
public class LoadClass {
    public void lc() {
        System.out.println(this.getClass().getClassLoader() + " loaded LoadClass");
    }
}
