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
            System.out.println("catch!");
            return 2;
        } finally {
            System.out.println("finally");
//            return 3;
        }
//        return 4;
    }

    /**
     * will return 3! why?
     * [return 2] in catch not executed?! will executed in finally disappeared!,如果没有异常出现finally中的还是会执行！
     * ===> 是不是可以这样认为，只要出现finally块！他里面的语句是一定要执行的！即使前边的语句不管是try内还是catch内有return！！！--不准确，看下一段！
     *
     *
     * ref:
     * https://www.geeksforgeeks.org/flow-control-in-try-catch-finally-in-java/
     * http://tutorials.jenkov.com/java-exception-handling/basic-try-catch-finally.html
     *  If your code has a return statement inside the try or catch block,
     *  the code inside the finally-block will get executed before returning from the method.
     *
     * [return 2] not executred I understand!
     *
     */

    public static void foo() {
        throw new NullPointerException("null!");
    }
}
