package com.github.ojoa.unicom;

import java.util.Scanner;

/**
 * Created by fengchen.zsx
 * Date: 18-9-25 下午8:46
 */
public class AlphaCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
//        sc.hasNextLine();
//        int x  = sc.nextInt();
        if (in == null || in.length() == 0) {
            System.out.println("input error");
            return;
        }

        in = in.trim();
        int[] dict = new int[26];

        for (int i = 0; i < in.length(); ++i) {
            char c = in.charAt(i);
            int idx = c - 'a';
            dict[idx]++;
        }

        int flag = 0;
        for (int i = 0; i < 26; ++i) {
            if (dict[i] == 0) {
                System.out.print((char)(i + 'a'));
            }else {
                flag++;
            }
        }
        if (flag == 26) {
            System.out.println(0);
        }
    }
}
