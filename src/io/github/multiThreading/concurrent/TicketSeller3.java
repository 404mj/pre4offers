package io.github.multiThreading.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zsx at 18-4-6
 * <p>
 * 依旧使用List但是加上Synchronized锁
 */
public class TicketSeller3 {

    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 100; ++i) tickets.add("票No." + i);
    }

    public static void main(String[] args) {
        //十个窗口并发卖票
        for (int i = 0; i < 10; ++i) {
            /*new Thread(() -> {
                while (true) {
                    synchronized (tickets) {
                        if (tickets.size() <= 0) break;

                        try {
                            TimeUnit.MICROSECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("售出： " + tickets.remove(0));
                    }
                }
            }).start(); */

            //两种加锁方式都可以
            //加锁效率不高！
            new Thread(() -> {
                synchronized (tickets) {
                    while (tickets.size() > 0) {
                        try {
                            TimeUnit.MICROSECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("售出： " + tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}