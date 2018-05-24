package io.github.multiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zsx at 18-4-1
 */
public class DemoCallableFuture implements Callable<Integer> {

    public static void main(String[] args) throws InterruptedException {
        DemoCallableFuture dcf = new DemoCallableFuture();
        FutureTask<Integer> ft = new FutureTask<Integer>(dcf);

        for (int i = 0; i < 10; i++) {
            //主线程
            System.out.println(Thread.currentThread().getName() + "的循环变量值为：" + i);
            Thread.sleep(30);
            if (i == 2) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值： " + ft.get());

        }catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e1){
            e1.printStackTrace();
        }
    }


    /**
     * 实现Callable的方式多线程方式要重写call方法，并用FutureTask包装，以FutureTask的实例包装Thread
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+ " " + i);
        }
        return i;
    }

}