package com.github.multiThreading;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zsx at 18-4-1
 */
public class ThreadMain {

    public static void main(String[] args) throws InterruptedException {

        /*DemoRunnable dr1 = new DemoRunnable("thread-1111");
        dr1.start();

        DemoRunnable dr2 = new DemoRunnable("thread-2222");
        dr2.start();
*/

        //使用countdownLatch实现主线程等待子线程：通用一个实例，主await，子countDown，
        //类比goroutine WaitGroup   ref:http://www.runoob.com/manual/jdk1.6/java/util/concurrent/CountDownLatch.html#await()
        CountDownLatch cd = new CountDownLatch(2);


        DemoExtendsThread det1 = new DemoExtendsThread("Thread-1", cd);
        det1.start();

        DemoExtendsThread det2 = new DemoExtendsThread("Thread-2", cd);
        det2.start();

        cd.await();
        System.out.println("主线程执行到这了。");

    }

}
