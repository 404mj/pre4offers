package com.github.multiThreading;

import java.util.concurrent.TimeUnit;

/**
 * Created by zsx at 18-4-4
 */
public class VolatileDemo {

    volatile boolean running = true;

    void m() {
        System.out.println("m start...");
        while (running) {

        }
        System.out.println("m ended ....");
    }

    public static void main(String[] args) {
        VolatileDemo vd = new VolatileDemo();
        new Thread(vd::m, "t").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        vd.running = false;
    }

}
