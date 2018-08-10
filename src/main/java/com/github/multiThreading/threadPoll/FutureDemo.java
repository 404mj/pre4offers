package com.github.multiThreading.threadPoll;

import java.util.concurrent.*;

/**
 * Created by zsx at 18-4-6
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        FutureTask<Integer> ftask = new FutureTask<>(() -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return 100;
        }); // ==> new callable() { Integer call(){...} }

        new Thread(ftask).start();

        System.out.println(ftask.get());//get会使主线程阻塞在这！
        */

        //*********************************************************
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> future = es.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return 100;
        });
        System.out.println(future.get());
        System.out.println(future.isDone());
        es.shutdown();//ThreadPool是一种服务，不显示的关闭就不会关闭。


    }
}
