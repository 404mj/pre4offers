package com.github.oj.inspur;

import java.util.Scanner;

/**
 * Created by fengchen.zsx
 * Date: 18-9-21 下午1:34
 */
public class DiZhuan {
    public static void main(String[] args) {
        long len, wid, a;
        int caseCt;
        long x, y, count;

        Scanner sc = new Scanner(System.in);
        caseCt = sc.nextInt();
        if (caseCt <= 0) {
            return;
        }
        for (int i = 0; i < caseCt; ++i) {
            len = sc.nextLong();
            wid = sc.nextLong();
            a = sc.nextLong();

            if (wid % a == 0) {
                x = wid / a;
            } else {
                x = wid / a + 1;
            }

            if (len % a == 0) {
                y = len / a;
            } else {
                y = len / a + 1;
            }

            count = x * y;
            System.out.println(count);
        }
    }
}
