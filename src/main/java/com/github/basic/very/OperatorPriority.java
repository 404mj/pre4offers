package com.github.basic.very;

/**
 * Author: fengchen.zsx
 * date: 2018/9/1 19:50
 * <p>
 * 很基础的点：运算符优先级！
 * http://www.slyar.com/blog/c-operator-priority.html
 * <p>
 * 这个输出结果我以为是1 1 0
 * 其实是 1 0 1！
 */
public class OperatorPriority {

    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;
        if (++a > 0 || ++b > 0) {
            ++c;
        }
        System.out.println(a + "  " + b + "  " + c);
    }

    /**
     * ref:
     *  第一级：[] () . -> ++后置 --后置
     *  第二级：-负号 前置++ 前置-- *（取地址） &  ~ ! sizeof
     *  第三极：/ * %
     *  第四级：+ -
     *  第五级：<< >>
     *  第六级：> >= < <=
     *  第七级：== !=
     *  位运算等。。。
     */
}
