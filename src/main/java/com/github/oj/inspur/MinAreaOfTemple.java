package com.github.oj.inspur;

import java.util.Scanner;

/**
 * Created by fengchen.zsx
 * Date: 18-9-21 下午1:46
 */
public class MinAreaOfTemple {


    public static void main(String[] args) {
        double PI = 3.1415926;
        int T;
        double x1, y1, x2, y2, x3, y3;
        double a, b, c;//a,b,c 为三角形边长；
        double A, B, C;//三角形角度的弧度值
        double r, S;//r 为三角形外接圆半径，S为三角形面积（用海伦公式求）
        double n;//正n边形
        double sn;//正n边形的面积
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T > 0) {
            x1 = sc.nextDouble();
            y1 = sc.nextDouble();
            x2 = sc.nextDouble();
            y2 = sc.nextDouble();
            x3 = sc.nextDouble();
            y3 = sc.nextDouble();

            a = getEdge(x1, y1, x2, y2);
            b = getEdge(x1, y1, x3, y3);
            c = getEdge(x2, y2, x3, y3);

            //三角形的角度公式cosA =（b2+c2-a2）/（2bc）;
            A = Math.acos((b * b + c * c - a * a) / (2 * b * c));
            B = Math.acos((a * a + c * c - b * b) / (2 * a * c));
            C = Math.acos((a * a + b * b - c * c) / (2 * a * b));
            //求三角形的面积，用海伦公式求解面积
            double p = (a + b + c) / 2;
            S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            r = a * b * c / 4 / S;
            double temp = gcdx(A, B);
            temp = gcdx(temp, C);
            n = PI / temp;
            sn = (r * r / 2) * Math.sin(2 * PI / n) * n;//三角形面积公式1/2 absin（A），n个三角形
            T = T - 1;
            System.out.println(String.format("%.6f", sn));
        }
        sc.close();
    }

    private static double gcdx(double x, double y) {
        while (Math.abs(x) > 0.0001 && Math.abs(y) > 0.0001) {
            if (x > y) {
                x = x - Math.floor(x / y) * y;
            } else {
                y = y - Math.floor(y / x) * x;
            }
        }
        return x + y;
    }

    private static double getEdge(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
