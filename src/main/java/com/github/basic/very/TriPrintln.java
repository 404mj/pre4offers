package com.github.basic.very;

/**
 * Created by fengchen.zsx
 * at 18-9-13 上午8:55
 */
public class TriPrintln {

    public static void main(String[] args) {
        int x = 4;
        System.out.println((x > 4) ? 99.0 : 9);

        /**
         * 1. http://blog.jobbole.com/93511/ 你真的三目运算符吗？
         * 第二和第三运算会判断是否对象和基本类型。进行类型转换
         *
         * 2.自右向左结合。
         *
         * 3. 如果都是基本数据类型， 参考类型转换规则！
         */
    }
}
