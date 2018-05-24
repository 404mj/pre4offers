package io.github.multiThreading;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by zsx at 18-4-4
 *
 * 模拟生产者消费者模式！！！
 *
 * 同步容器，使用wait/notify
 *
 */
public class SynContainer<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    public synchronized void put(T t) {
        while (lists.size() == MAX) {//为什么是while不是if？
            /**
             * 操作系统的进程状态理解用在这里也是合适的，mashibing的讲法类似加上我自己的理解：
             * 线程发现container已经满了，就将自己阻塞，直到消费者消费之后，再从阻塞当时的工作恢复过来接着执行！
             * 但是， OS理论告诉我们， *阻塞* 之后线程变为 *就绪*，唤醒之后上CPU运行的时候，不一定就是你接着上， 很有可能是别的
             * 线程先上再轮到你。如果只用if判断， 接着执行的时候添加，就很有可能出错， 因为之前上CPU的线程可能又填满了。
             * 可以改过来试试~~~~~
             */
            try {
                //<effictive java>中说wait几乎总是和while一起使用
                this.wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lists.add(t);
        ++count;
        this.notifyAll();
    }

    public synchronized T get() {
        T t = null;
        while (lists.size() == 0) {
            try {
                this.wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = lists.removeFirst();
        count--;
        this.notifyAll();//为什么notifyAll不是notify？因为叫醒一个的话，说不定又是一样的
        return t;
    }


    /**
     * main
     */
    public static void main(String[] args) {
        SynContainer s = new SynContainer();

        //消费者
        for (int i =0; i< 10; ++i) {
            new Thread(() -> {
                for (int j =0; j< 5; j++) System.out.println("consume: " + s.get());
            }, "consumer-" + i).start();
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
//                    System.out.println("provide " + j);
                    s.put("product-" + j);
                }
            }).start();
        }
    }

}
