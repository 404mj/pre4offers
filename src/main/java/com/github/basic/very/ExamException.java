package com.github.basic.very;

/**
 * Author: fengchen.zsx
 * date: 2018/9/1 19:37
 */
public class ExamException {

    public static void main(String[] args) {
        ExamException e = new ExamException();
        System.out.println(e.test("null"));
    }

    public static int test(String args) {
        try {
            foo();
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
//        return 4;
    }

    public static void foo() {
        throw new NullPointerException("null!");
    }
}
