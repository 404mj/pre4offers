package com.github.multiThreading.concurrent;

import java.util.Vector;

/**
 * Created by zsx at 18-4-6
 */
public class TicketSeller2 {

    static Vector<String> tickets = new Vector<>();

    static {
        for (int i = 0; i < 1000; ++i) tickets.add("票No." + i);
    }

    public static void main(String[] args) {
        //十个窗口并发卖票
        for (int i = 0; i < 10; ++i) {
            new Thread(() -> {
                while (tickets.size() > 0) {

                    //改用Vector依旧有问题， 因为先进行了判断，然后remove，这中间就会出现问题。

                    System.out.println("售出： " + tickets.remove(0));
                }
            }).start();
        }
    }
}
