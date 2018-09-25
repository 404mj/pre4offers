package com.github.ojoa.unicom;

/**
 * Created by fengchen.zsx
 * Date: 18-9-25 下午9:06
 *
 * 计算最小共倍数
 * https://www.cnblogs.com/liuzhen1995/p/6423600.html
 *
 * https://www.cnblogs.com/JumperMan/p/6529748.html
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LCM {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> test = new ArrayList<>();

        while (sc.hasNextLine()) {
            String s = sc.nextLine();

            if (s.length() == 0) break;
            test.add(s);
        }

        for (String s : test) {
            String[] in = s.split(" ");
            int x = Integer.valueOf(in[0]);
            int y = Integer.valueOf(in[1]);
            System.out.println((x * y) / getGcd(x, y));
        }
        sc.close();
    }

    private static int getGcd(int m, int n) {
        while (n > 0) {
            int tmp = m % n;
            m = n;
            n = tmp;
        }
        return m;
    }


}