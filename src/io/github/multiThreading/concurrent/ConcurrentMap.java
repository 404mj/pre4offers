package io.github.multiThreading.concurrent;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created by zsx at 18-4-6
 *
 * 查看这几个Map在高并发的效率
 */
public class ConcurrentMap {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();//653
//        Map<String, String> map = new ConcurrentSkipListMap<>();//1140

//        Map<String, String> map = new Hashtable<>();//657
//        Map<String, String> map = new HashMap<>();//615

        Random r  = new Random();
        Thread[] threads = new Thread[100];

        CountDownLatch cdl = new CountDownLatch(threads.length);
        long start = System.currentTimeMillis();

        for (int i = 0; i< threads.length; ++i) {
            threads[i] = new Thread(() -> {
                for (int j=0; j<10000; j++) {
                    map.put("k" + r.nextInt(100000), "v" + r.nextInt(100000));
                }
                cdl.countDown();
            });
        }

        Arrays.asList(threads).forEach(t -> t.start());

        try {
            cdl.await();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
