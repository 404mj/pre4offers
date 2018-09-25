package com.github.ojoa.tecent;

import java.util.Scanner;

/**
 * Author: fengchen.zsx
 * date: 2018/8/31 21:00
 * <p>
 * https://blog.csdn.net/qq_29567701/article/details/79829274
 * <p>
 * https://blog.csdn.net/qq_36391130/article/details/82053140
 * <p>
 * 编程题：小Q的歌单
 * https://www.nowcoder.com/questionTerminal/f3ab6fe72af34b71a2fd1d83304cbbb3?orderByHotValue=1&page=1&onlyReference=false
 */
public class SongCombnation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int x = sc.nextInt();
        int xn = sc.nextInt();
        int y = sc.nextInt();
        int yn = sc.nextInt();

        SongCombnation songC = new SongCombnation();

        System.out.println(songC.soulation(x, xn, y, yn, k));
    }


    public long soulation(int x, int xn, int y, int yn, int k) {
        long mod = 1000000007;
        assert (x > 0 && y > 0 && k > x && k > y && xn > 0 && yn > 0 && x != y);
        long res = 0;
        for (int i = 0; i < xn; i++) {
            for (int j = 0; j < yn; j++) {
                if (x * i + y * j == k)
                    res += combnation(i, xn) * combnation(j, yn);
            }
        }
        return (res % mod);
    }

    public int combnation(int son, int mother) {
        int up = 1, down = 1;
        if (mother < son || son < 0)
            return 0;
        if (son > (mother >> 2))  //C(3，8) == C(5，8)
            son = mother - son;
        if (son == 0)
            return 1;
        for (int i = 0; i < son; i++) {
            up *= (mother - i);
            down *= (i + 1);
        }
        return (up / down);
    }

}