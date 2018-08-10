package com.github.multiThreading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsx at 18-4-4
 */
public class VolatileDemo2 {
    volatile int count = 0;

    synchronized void m() {
        for (int i = 0; i< 10000; ++i) {
            count++;
        }
    }

    public static void main(String[] args) {
        VolatileDemo2 vd2 = new VolatileDemo2();
        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i<10; i++) {
            threads.add(new Thread(vd2::m, "thread-" + i));
        }

        threads.forEach((o)-> o.start());

       /*threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/

        System.out.println(vd2.count);
    }

}
