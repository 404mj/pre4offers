package com.github.multiThreading.threadPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by zsx at 18-4-6
 *
 * 这是一种线程池，newFixedThreadPool
 *
 * 比较传统的求1-200000之前的质数的时间
 * 和
 * 线程池并行求解的时间效率
 *
 */
public class SolvePrime {

    static boolean isPrime(Integer num) {
        for (int i = 2; i<= num/2; i++) {
            if (num%i == 0) return false;
        }
        return true;
    }

    static List<Integer> getPrime(Integer i, Integer j) {
        List<Integer> res = new ArrayList<>();
        for (int n = i; n <= j; n++) {
            if (isPrime(n)) res.add(n);
        }
        return res;
    }


    static class ParallTask implements Callable<List<Integer>> {
        int start, end;

        ParallTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public List<Integer> call() throws Exception {
            List<Integer> r = getPrime(this.start, this.end);
            return r;

        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long s = System.currentTimeMillis();
        List<Integer> results = getPrime(1, 200000);
        long end = System.currentTimeMillis();
        System.out.println("串行用时：" + (end - s));

        final  int cpunum = 4;
        ExecutorService es = Executors.newFixedThreadPool(cpunum);

        //为什么不平均分配。
        ParallTask task1 = new ParallTask(1,80000);
        ParallTask task2 = new ParallTask(80001, 130000);
        ParallTask task3 = new ParallTask(130001, 170000);
        ParallTask task4 = new ParallTask(170001, 200000);

        Future<List<Integer>> f1 = es.submit(task1);
        Future<List<Integer>> f2 = es.submit(task2);
        Future<List<Integer>> f3 = es.submit(task3);
        Future<List<Integer>> f4 = es.submit(task4);

        s = System.currentTimeMillis();
        f1.get();
        f2.get();
        f3.get();
        f4.get();
        end = System.currentTimeMillis();
        System.out.println("并行用时：" + (end - s));
        es.shutdown();

    }

}
