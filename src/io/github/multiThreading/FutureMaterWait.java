package io.github.multiThreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zsx at 18-4-1
 */
public class FutureMaterWait {

    static ExecutorService executorService = Executors.newFixedThreadPool(1);

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SubThread thread = new SubThread();
        // thread.start();
        Future future = executorService.submit(thread);
        mainThreadOtherWork();
        System.out.println("Waiting sub thread done.");
        future.get();
        // try {
        // thread.join();
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        System.out.println("now all done.");
        executorService.shutdown();
    }

    /**
     * 主线程其他工作
     */
    private static void mainThreadOtherWork() {
        System.out.println("main thread work start");
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread work done.");
    }

    /**
     * 子线程！！
     */
    public static class SubThread extends Thread {
        @Override
        public void run() {
            working();
        }

        private void working() {
            System.out.println("sub thread start working.");
            busy();
            System.out.println("sub thread stop working.");
        }

        private void busy() {
            try {
                sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}
