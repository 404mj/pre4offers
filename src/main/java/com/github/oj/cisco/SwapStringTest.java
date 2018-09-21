package com.github.oj.cisco;

/**
 * Created by fengchen.zsx
 * Date: 18-9-20 下午10:09
 */
public class SwapStringTest {
    public static void main(String[] args) {
        String a = "1";
        String b = "2";

        swapString(a, b);

        System.out.println("a=" + a + "  b=" + b);
    }

    public static void swapString(String a, String b) {
        String tmp = a;
        a = b;
        b = tmp;
    }
}
