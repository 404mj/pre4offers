package com.github.multiThreading;

/**
 * Created by zsx at 18-4-1
 *
 * 实现Runnable接口 --- 多线程！！！
 */
public class DemoRunnable implements Runnable {
    private Thread t;
    private String threadName;

    public DemoRunnable(String name) {
        this.threadName = name;
        System.out.println("Creating " + name);
    }

    /**
     * 必须有！
     */
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("thread " + threadName + "interruped.");
        }
        System.out.println("thread " + threadName + "exiting!");
    }

    public void start() {
        System.out.println("Starting ---" + threadName);
        if (null == t) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
