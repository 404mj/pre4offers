package com.github.ojoa.unicom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fengchen.zsx
 * Date: 18-9-25 下午5:11
 */
public class ShuiXianNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = n; i <= m; i++) {
                char[] strs = String.valueOf(i).toCharArray();
                int amount = 0;
                for (char s : strs) {
                    amount = amount + (s - 48) * (s - 48) * (s - 48);
                }
                if (amount == i) {
                    list.add(i);
                    num++;
                }
            }
            if (num == 0) {
                System.out.println("no");
            } else {
                for (int j = 0; j < num - 1; j++) {
                    System.out.print(list.get(j) + " ");
                }
                System.out.println(list.get(num - 1));
            }
        }

    }
}
