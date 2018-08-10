package com.github.multiThreading.concurrent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by zsx at 18-4-6
 *
 * 使用并发数据结构
 */
public class TicketSeller4 {
    static Queue<String> tickets = new ConcurrentLinkedDeque<>();

    static {
        for (int i = 0; i < 100; ++i) tickets.add("票No." + i);
    }

    public static void main(String[] args) {
        //十个窗口并发卖票
        for (int i=0; i< 10; ++i) {
            new Thread(() -> {
                while (true) {
                    //不会出问题， 效率也高， 虽然有判断，但是没有对队列做操作。主要是poll方法
                    String s = tickets.poll();
                    if (s == null) break;
                    else System.out.println("售出： " + s);
                }
            }).start();
        }
    }
}
