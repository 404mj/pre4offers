package com.github.oj.cisco;

/**
 * Created by fengchen.zsx
 * Date: 18-9-20 下午10:18
 */
public class ExtendsProblem {
    public static void main(String[] args) {
        B b = new B();
        b.test();
        b.three();
    }
}

class A {
    public void one() {
        System.out.println("one");
    }

    public void two() {
        System.out.println("two");
    }
    public void three() {
        System.out.println("three");
    }

    public void four() {
        System.out.println("four");
    }

    public void test() {
        this.one();
        this.two();
        this.three();
        this.four();
    }
}

class B extends A {
    public void one() {
        System.out.println("Bone");
    }

    public void two() {
        System.out.println("Btwo");
    }
    public void three() {
        System.out.println("Bthree");
    }

    public void four() {
        System.out.println("Bfour");
    }
}
