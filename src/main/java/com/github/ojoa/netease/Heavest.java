package com.github.ojoa.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: fengchen.zsx
 * date: 2018/8/11 16:06
 */
public class Heavest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heaps = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += sc.nextInt();
            heaps[i] = sum;
        }
        int m = sc.nextInt();
        int[] ques = new int[m];
        for (int i = 0; i < m; i++) {
            ques[i] = sc.nextInt();
        }

        // 求解, 使用二分查找！
        /**
         * 才知道java内置的有二分查找工具！
         */
        for (int i = 0; i < m; i++) {
            int pos = Arrays.binarySearch(heaps, ques[i]);
            if (pos > 0) {
                System.out.println(pos + 1);
            } else {
                System.out.println(Math.abs(pos));
            }
        }
    }
}
