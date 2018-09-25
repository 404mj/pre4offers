package com.github.ojoa.inspur;

import java.util.Scanner;

/**
 * Created by fengchen.zsx
 * Date: 18-9-21 下午1:46
 */
public class MinAreaOfTemple {


    public static void main(String[] args) {
        double PI = 3.1415926;
        int t;
        double x1, y1, x2, y2, x3, y3;
        double a, b, c;//a,b,c 为三角形边长；
        double A, B, C;//三角形角度的弧度值
        double r, S;//r 为三角形外接圆半径，S为三角形面积（用海伦公式求）
        double n;//正n边形
        double sn;//正n边形的面积
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t > 0) {
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
            t = t - 1;
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


/**
 #include <stdio.h>
 #include <math.h>
 #define pi 3.14159265354
 #define esp 1e-7
 double gcd(double,double);
 double edge(double,double,double,double);
 int main(void)
 {
 double x1,y1,x2,y2,x3,y3;
 double r,A,B,C,a,b,c,area;
 double  n;
 scanf("%lf%lf%lf%lf%lf%lf",&x1,&y1,&x2,&y2,&x3,&y3);
 a=edge(x1,y1,x2,y2);
 b=edge(x1,y1,x3,y3);
 c=edge(x2,y2,x3,y3);
 A=acos((b*b+c*c-a*a)/(2*b*c));
 B=acos((a*a+c*c-b*b)/(2*a*c));
 C=acos((a*a+b*b-c*c)/(2*a*b));
 double d=gcd(A,B);
 d=gcd(d,C);
 n=pi/d;
 area=fabs(x2*y3+x3*y1+x1*y2-x3*y2-x1*y3-x2*y1)/2;
 r=a*b*c/4/area;
 printf("%.8f\n",(n*r*r/2)*sin(2*pi/n));
 return 0;
 }double edge(double x1,double y1,double x2,double y2)
 {
 return sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
 }
 double gcd(double x,double y)//这里是一中求浮点型数据的最大公约数的一种方法，比较巧妙，值得学习。
 {
 while(fabs(x)>esp&&fabs(y)>esp)
 {
 if(x>y)
 x-=floor(x/y)*y;
 else
 y-=floor(y/x)*x;
 }
 return x+y;
 }

 */

/**
 #include<stdio.h>
 #include<string.h>
 #include<assert.h>
 #include<math.h>
 #include<algorithm>
 #include<iostream>
 using namespace std;

 double gcdx(double x, double y)
 {
 while (fabs(x)>0.0001&&fabs(y)>0.0001)
 {
 if (x > y) { x = x - floor(x / y)*y; }
 else       { y = y - floor(y / x)*x; }
 }
 return x + y;
 }

 double get_edge(double x1, double y1,double x2,double y2){
 return sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
 }
 int main()
 {
 double PI = 3.1415926;
 int T;
 double x1, y1, x2, y2, x3, y3;
 double a, b, c;
 double A, B, C;
 double r, S;
 double n;
 double Sn;
 cin >> T;
 while(T>0){
 cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;
 a = get_edge(x1, y1, x2, y2);
 b = get_edge(x1, y1, x3, y3);
 c = get_edge(x2, y2, x3, y3);

 A = acos((b*b + c*c - a*a) / (2 * b*c));
 B = acos((a*a + c*c - b*b) / (2 * a*c));
 C = acos((a*a + b*b - c*c) / (2 * a*b));

 double p = (a + b + c) / 2;
 S = sqrt(p*(p - a)*(p - b)*(p - c));
 r = a*b*c / 4 / S;
 double temp = gcdx(A, B);
 temp = gcdx(temp, C);

 n = PI / temp;
 Sn = (r*r / 2)*sin(2 * PI / n)*n;
 T = T - 1;
 printf("%.6f\n", Sn);
 }
 return 0;
 }

 */

/**
 *
 * #include <cstdio>
 * #include <cstring>
 * #include <math.h>
 * #include <algorithm>
 * using namespace std ;
 * #define PI acos(-1)
 * #define eqs 0.01
 * double gcd(double a,double b)
 * {
 *     return a < eqs ? b : gcd(fmod(b,a),a);
 * }
 * int main()
 * {
 *     double x1 , y1 , x2 , y2 , x3 , y3 ;
 *     double a , b , c , p , s , r , k ;
 *     double A , B , C ;
 *     while(~scanf("%lf %lf %lf %lf %lf %lf", &x1, &y1, &x2, &y2, &x3, &y3)){
 *     a = sqrt( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) ) ;
 *     b = sqrt( (x2-x3)*(x2-x3) + (y2-y3)*(y2-y3) ) ;
 *     c = sqrt( (x1-x3)*(x1-x3) + (y1-y3)*(y1-y3) ) ;
 *     p = ( a + b + c ) / 2.0 ;
 *     s = sqrt( p * (p-a) * (p-b) * (p-c) ) ;
 *     r = a * b * c / ( 4 * s ) ;
 *     if( a > c )
 *     {
 *         k = a ; a = c ; c = k ;
 *     }
 *     if( b > c )
 *     {
 *         k = b ; b = c ; c = k ;
 *     }
 *     A = 2 * asin(a/(2*r)) ;
 *     B = 2 * asin(b/(2*r)) ;
 *     C = 2 * PI - A - B ;
 *     //printf("%lf %lf %lf\n", A, B, C) ;
 *     p = gcd(A,B);
 *     p = gcd(p,C) ;
 *     //printf("%lf %lf\n", r, p) ;
 *     printf("%.6lf\n", (PI*r*r*sin(p))/p ) ;
 *     }
 *     return 0;
 * }
 *
 *
 */
