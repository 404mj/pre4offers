package com.github.ojoa.inspur;

import java.util.Scanner;

/**
 * Created by fengchen.zsx
 * Date: 18-9-24 下午4:21
 *
 * 浪潮2018笔试第一题，第二次做，google遍了，几乎什么方案都用上了全都是所有测试均未通过。
 * 不是为什么？？
 * 赛码网的问题？
 * 几乎把能搜索到的问题都查到了， 原型是codeforce上的一道题：ancient berland circus。
 * C/C++/Java都试了！在那个系统上都不行，真是日了狗！！
 *
 * http://sbaldrich.github.io/cp/52-300-hello-again-geometry/
 *https://www.cnblogs.com/hua-dong/p/9511545.html
 *
 * http://h0rnet.hatenablog.com/entry/2017/05/31/1C_-_Ancient_Berland_Circus
 * https://blog.csdn.net/crazy852456/article/details/15432175
 * http://www.cnblogs.com/rootial/archive/2013/05/14/3078104.html
 * http://www.voidcn.com/article/p-hxjyywla-tm.html
 * http://www.voidcn.com/article/p-addbltww-bdk.html
 * http://www.voidcn.com/article/p-zqobpojp-kd.html
 * http://www.voidcn.com/article/p-cujkecdj-rb.html
 * https://blog.csdn.net/winddreams/article/details/42532203
 * https://topcoder.g.hatena.ne.jp/JAPLJ/20110302/1299072806
 *
 *
 * https://www.luogu.org/problemnew/solution/CF1C  这个讲的很清楚！！！
 * http://massivealgorithms.blogspot.com/2016/11/codeforces-1c-ancient-berland-circus.html 也不错哦！
 * https://blog.csdn.net/ling_xiao007/article/details/51932684  两种思路！
 * http://coltonstack.com/stack.do?pclass_id=3&stackpost_id=35
 *
 *
 * https://github.com/aeurielesn/codeforces/blob/master/1/C/ancient-berland-circus.cc
 *https://www.cnblogs.com/gongxijun/p/3923105.html
 *
 *
 */
public class AncientBerlandCircus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {

            double Ax = sc.nextDouble(), Ay = sc.nextDouble();
            double Bx = sc.nextDouble(), By = sc.nextDouble();
            double Cx = sc.nextDouble(), Cy = sc.nextDouble();

            double a = Math.sqrt((Bx - Cx) * (Bx - Cx) + (By - Cy) * (By - Cy));
            double b = Math.sqrt((Ax - Cx) * (Ax - Cx) + (Ay - Cy) * (Ay - Cy));
            double c = Math.sqrt((Ax - Bx) * (Ax - Bx) + (Ay - By) * (Ay - By));

            double p = (a + b + c) / 2;
            double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            double R = a * b * c / (4 * S);

            double alpha = Math.acos((b * b + c * c - a * a) / (2 * b * c));
            double beta = Math.acos((a * a + c * c - b * b) / (2 * a * c));
            double gamma = Math.PI - alpha - beta;

            long n = Math.round(Math.PI / gcd(beta, gcd(alpha, gamma)));
            System.out.println(String.format("%.6f", (R * R * Math.sin(2 * Math.PI / n) * n / 2)));
            t--;
        }
        sc.close();
    }

    private static double gcd(double a, double b) {
        if (a < b) return gcd(b, a);
        if (Math.abs(b) < 0.001) {
            return a;
        } else {
            return (gcd(b, a - Math.floor(a / b) * b));
        }
    }
}

/**
 * public static void main(String[] args) throws IOException {
 * BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
 * <p>
 * String pointA[] = stdin.readLine().split(" ");
 * String pointB[] = stdin.readLine().split(" ");
 * String pointC[] = stdin.readLine().split(" ");
 * <p>
 * double Ax = Double.parseDouble(pointA[0]), Ay = Double.parseDouble(pointA[1]);
 * double Bx = Double.parseDouble(pointB[0]), By = Double.parseDouble(pointB[1]);
 * double Cx = Double.parseDouble(pointC[0]), Cy = Double.parseDouble(pointC[1]);
 * <p>
 * double a = Math.sqrt((Bx - Cx) * (Bx - Cx) + (By - Cy) * (By - Cy));
 * double b = Math.sqrt((Ax - Cx) * (Ax - Cx) + (Ay - Cy) * (Ay - Cy));
 * double c = Math.sqrt((Ax - Bx) * (Ax - Bx) + (Ay - By) * (Ay - By));
 * <p>
 * double p = (a + b + c) / 2;
 * double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
 * double R = a * b * c / (4 * S);
 * <p>
 * double alpha = Math.acos((b * b + c * c - a * a) / (2 * b * c));
 * double beta = Math.acos((a * a + c * c - b * b) / (2 * a * c));
 * double gamma = Math.PI - alpha - beta;
 * <p>
 * long n = Math.round(Math.PI / gcd(beta, gcd(alpha, gamma)));
 * PrintWriter stdout = new PrintWriter(System.out);
 * stdout.println(R * R * Math.sin(2 * Math.PI / n) * n / 2);
 * stdout.close();
 * }
 * <p>
 * private static double gcd(double a, double b) {
 * if (a < b) return gcd(b, a);
 * if (Math.abs(b) < 0.001) {
 * return a;
 * } else {
 * return (gcd(b, a - Math.floor(a / b) * b));
 * }
 * }
 */

/*

#include<cstdio>
#include<cmath>
const double Pi=acos(-1.0);        //π的值
        const double EPS=1E-2;            //控制精度
        struct Point {
        double x,y;
        }P[3];
        double len[3],a[3];        //len为边长，a为圆心角角度。
        double Get(int i,int j) {    //求两点之间距离
        return sqrt((P[i].x-P[j].x)*(P[i].x-P[j].x)+(P[i].y-P[j].y)*(P[i].y-P[j].y));
        }
        double gcd(double a,double b) {    //double类型的最大公约数
        if(fabs(b)<EPS)
        return a;
        if(fabs(a)<EPS)
        return b;
        return gcd(b,fmod(a,b));    //fmod(a,b), double类型的取模
        }
        int main() {
        double t=0.0,A,r;
        for(int i=0;i<3;++i)
        scanf("%lf%lf",&P[i].x,&P[i].y);
        for(int i=0;i<3;t+=len[i],++i)
        len[i]=Get(i,(i+1)%3);
        t/=2;
        A=sqrt(t*(t-len[0])*(t-len[1])*(t-len[2]));    //求三角形面积
        r=len[0]*len[1]*len[2]/(4*A);                //求三角形外接圆半径
        for(int i=0;i<2;++i)
        a[i]=acos(1-len[i]*len[i]/(2*r*r));        //求圆心角度数
        a[2]=2*Pi-a[0]-a[1];                        //为防止误差，最后一个圆心角根据三角形三边作为弦所对的三个圆心角之和为360°求出
        t=gcd(a[0],gcd(a[1],a[2]));                    //求圆心角的最大公约数
        printf("%.6lf",(Pi*r*r*sin(t))/t);            //求正多边形面积
        return 0;
        }

        */