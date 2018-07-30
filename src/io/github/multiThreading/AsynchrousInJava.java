package io.github.multiThreading;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Author: fengchen.zsx
 * date: 2018/7/29 14:07
 */
public class AsynchrousInJava {

    public static void main(String[] args) {
        Task t = new Task();
        FutureTask<String> futureTask = new DemoFutureTask<>(t);


        //上面是用了一个内部Task类 其实在java8中完全可以按照小面这样写：
        FutureTask<String> futureTask1 = new FutureTask<>(()->{
            TimeUnit.SECONDS.sleep(3);
            return "second task is done";
        });

//        new Thread((futureTask)).start();
        ExecutorService espool = Executors.newSingleThreadExecutor();
        espool.submit(futureTask1);
        try {
            Map<String, Integer> map  =new HashMap<>();

            String mres = futureTask.get();
            String mres1 = futureTask1.get();
            System.out.println("this msg is from master thread, I got res is: " + mres);
        } catch (Exception e) {
            e.printStackTrace();
        }
        espool.shutdown();
    }


    /**
     * 任务类内部
     */
    static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("task call end");
            return "from call";
        }
    }

    static class DemoFutureTask<String> extends FutureTask<String> {

        /**
         * 重写构造方法
         */
        public DemoFutureTask(Callable<String> callable) {
            super(callable);
        }

        /**
         * FutureTask完成之后的回调
         */
        @Override
        protected void done() {
            try {
                if (isDone()) {
                    String res = this.get();
                    System.out.println("this msg is from Done(), i got res is: " + res);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
    }

}
