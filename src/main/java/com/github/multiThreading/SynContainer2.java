package com.github.multiThreading;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zsx at 18-4-4
 *
 * 模拟生产者消费者模式！！！
 *
 * 同步容器， 支持2个生产者和10个消费者
 * 使用Lock和Condition实现
 *
 * notifyAll叫醒所有，signalAll是叫醒所有的指定的对象，效率高一点。
 *
 */
public class SynContainer2<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    private Lock  lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();


    public void put(T t) {
        try {
            lock.lock();
            while (lists.size() == MAX) {
                producer.await();
            }
            lists.add(t);
            ++count;
            consumer.signalAll();//通知消费者线程进行消费
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public T get() {
        T t = null;
        try {
            lock.lock();
            while (lists.size() == 0) {
                consumer.await();
            }
            t = lists.removeFirst();
            count--;
            producer.signalAll();//通知生产者生产
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;
    }


    public static void main(String[] args) {
        SynContainer2 s2 = new SynContainer2();

        //消费者
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j< 5; j++) System.out.println("consume: " + s2.get());
            }, "c-" +i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        //生产者
        for (int i = 0; i< 2; ++i) {
            new Thread(() -> {
                for (int j = 0; j< 25; j++) {
                    s2.put("product-" + j);
                }
            }).start();
        }
    }

}
