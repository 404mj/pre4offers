package com.github.multiThreading.threadPoll;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zsx at 18-4-6
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i< 6; ++i) {
            es.execute(() -> {
                try {
                    TimeUnit.MICROSECONDS.sleep(200);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        System.out.println(es);

        es.shutdown();
        System.out.println(es.isTerminated());
        System.out.println(es.isShutdown());
        System.out.println(es);

        TimeUnit.SECONDS.sleep(3);
        System.out.println(es.isTerminated());
        System.out.println(es.isShutdown());
        System.out.println(es);
    }
}
