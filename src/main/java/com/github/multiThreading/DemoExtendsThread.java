package com.github.multiThreading;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zsx at 18-4-1
 */
public class DemoExtendsThread extends Thread {
    private Thread thread;
    private String threadName;
    private CountDownLatch cd;

    public DemoExtendsThread(String threadName, CountDownLatch cd) {
        this.threadName = threadName;
        this.cd = cd;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 2; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }

        }catch (InterruptedException e) {
            System.out.println("Thread " + threadName+ " interuppted");
        }
        System.out.println("thread " + threadName + "exitting");
        cd.countDown();
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (null == thread) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

}
