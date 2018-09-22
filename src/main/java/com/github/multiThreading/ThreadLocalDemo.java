package com.github.multiThreading;

import java.util.concurrent.TimeUnit;

/**
 * Created by zsx at 18-4-4
 */
public class ThreadLocalDemo {

    volatile static Person  p = new Person("zhangSan");

    static ThreadLocal<Person> tlp = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.getName());
            System.out.println(tlp.get());
        }).start();


        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
//            p.setName("lisi");
            tlp.set(new Person("lisi"));

        }).start();
    }
}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
