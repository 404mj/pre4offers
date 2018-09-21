package com.github.oj.cisco;

/**
 * Created by fengchen.zsx
 * Date: 18-9-20 下午10:13
 */
public class DoubleTest {
    public static void main(String[] args) {
        double d1 = 1024D * 1024 * 1024 * 1024;
        double d2 = 1024L * 1024 * 1024 * 1024;
        double d3 = (long) 1024 * 1024 * 1024 * 1024;
        double d4 = (double) 1024 * 1024 * 1024 * 1024;
        double d5 = 1024 * 1024 * 1024 * 1024;

        System.out.println("d1=" + d1);
        System.out.println("d2=" + d2);
        System.out.println("d3=" + d3);
        System.out.println("d4=" + d4);
        System.out.println("d5=" + d5);

    }
}
