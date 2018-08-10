package com.github.multiThreading.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsx at 18-4-6
 *
 * 假设10个窗口对外卖票
 */
public class TicketsSeller1 {
    static List<String> tickets = new ArrayList<>();

    static {
        for (int  i = 0; i < 1000; ++i) tickets.add("票No." + i);
    }

    public static void main(String[] args) {
        //十个窗口并发卖票
        for (int i=0; i< 10; ++i) {
            new Thread(() -> {
                while (tickets.size() > 0) {
                    //因为先进行了判断，然后remove，这中间就会出现问题。remove不是原子性的，
                    System.out.println("售出： " + tickets.remove(0));
                }
            }).start();
        }
        /**
         * 多执行几次就会出现：  java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
         */

    }
}