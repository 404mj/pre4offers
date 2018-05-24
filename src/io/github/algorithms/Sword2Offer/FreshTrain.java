package io.github.algorithms.Sword2Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by zsx at 18-4-18
 *
 * 一些java变成提
 */
public class FreshTrain {

    public static void main(String[] args) {

        FreshTrain ft = new FreshTrain();

        //        ft.printOne2TenWithoutLoop();
//        ft.swapWithoutVariable();
//        ft.checkEvenOdd(3);
//        ft.reverseStr("hello, world");
//        System.out.println(ft.recurReverse("hello, world"));
//        ft.fib(1, 1, 50);
//        ft.chStr("aa这是bb中文");
//        ft.isAcronymBetter("zsxo", "oszx");


    }

    /**
     * list 去重复, 除了普通方法之外
     * 在java8基础上基于Stream API: https://howtodoinjava.com/java-8/java-stream-distinct-examples/
     */
    public void distinctList() {

    }

    /**
     * 检查是不是颠倒字符??
     * https://www.codementor.io/blog/java-interview-sample-questions-answers-du107xs23
     * 这里面一些挺好的java问题!!就是那种诡异的基础问题!
     */
    public void isAcronymBetter(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        System.out.println(Arrays.equals(s1Chars,s2Chars));
    }

    /**
     * ArrayList remove问题
     */
    public void wiredListRemoval() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);


//        ints.remove(2);
        ints.remove(Integer.valueOf(2));

        System.out.println(ints);
    }

    /**
     * 测试中文字符串问题!没有啊!
     */
    public void chStr(String str) {
        System.out.println(str.length());
        System.out.println(str.substring(1,6));
    }

    /**
     * 限制大小的斐波纳挈
     */
    public void fib(int bbfore, int before, int max) {
        int next;
        if ((next = bbfore + before) < max) {
            System.out.println(next);
            fib(before, next, max);
        }
    }

    /**
     * 反转string, 不用string方法,
     * 其实好多中方法
     */
    public void reverseStr(String str) {
        StringBuilder bs = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; --i) {
            bs.append(str.charAt(i));
        }
        System.out.println(bs.toString());
    }

    /**
     * 递归方式实现
     */
    public String recurReverse(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return recurReverse(str.substring(1)) + str.charAt(0);
    }

    /**
     * 更简单!
     */
    public String moreEasy(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    /*
     * 不用取余检测奇偶
     */
    public void checkEvenOdd(int num) {
        //是不是偶数?使用右移相当于除2, 然后再乘2, 看是否和原来值想等, 有点繁琐!
//        System.out.println(((num >> 1) << 1) == num);

        /**
         * 这种方式更geek: 某一个数字只要二进制位的最后一个位是0,那就是偶数:
         * 以为前边都是2的n次方, 最后一位是1的话就加一就变成奇数了!!
         * 所以判断最后一位即可, & 1 就行!!
         */
        System.out.println((num & 1) == 0);

    }


    /**
     * 交换两个数不用第三个变量
     */
    public void swapWithoutVariable() {
        int a = 1;
        int b = 9;
        //第一种方式
//        a = a^b;
//        b = a^b;
//        a = a^b;

//        第二种
        a = a + b;
        b = a - b;
        a = a - b;


        System.out.println(a + " " + b);
    }


    /**
     * 不用循环打印1---10
     */
    public void printOne2TenWithoutLoop() {
        recursivePrint(1);
    }

    public void recursivePrint(int num) {
        if (num <= 10) {
            System.out.println(num);
            recursivePrint(num + 1);
        }
    }

}
