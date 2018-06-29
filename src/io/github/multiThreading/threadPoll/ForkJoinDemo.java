package io.github.multiThreading.threadPoll;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Author: fengchen.zsx
 * date: 2018/6/18 10:54
 * ref: http://ifeve.com/talk-concurrency-forkjoin/ && http://ifeve.com/fork-join-1/
 * <p>
 * "工作窃取":每个线程维护一个双端队列从头执行， 别的线程可以从尾部拿任务执行
 * <p>
 * 1. 分割任务 RecursiveAction:没有返回结果  RecursiveTask:有返回结果
 * 2. 执行任务合并结果: ForkJoinPool
 * <p>
 * jdk7开始针对一个特定领域问题设计的，用来解决可以使用分而治之技术将任务分解成更小的问题，
 * 在一个任务中，**检查你想要解决问题的大小，如果它大于一个既定的大小，把它分解成更小的任务**,
 * 然后用这个框架来执行。如果问题的大小是小于既定的大小，你直接在任务中解决这问题。
 * 它返回一个可选地结果。
 * <p>
 * Note:
 * 1. 任务不能抛出异常， 手动处理。
 * 2. 同步模式
 */
public class ForkJoinDemo {

    /**
     * If (problem size < default size){
     * tasks=divide(task);
     * execute(tasks);
     * } else {
     * resolve problem using another algorithm;
     * }
     */

    public static void main(String[] args) {
        int[] counted = new int[1000];
        for (int i = 0; i < 1000; i++) {
            counted[i] = i + 1;
        }

        CountForkJoinTask task = new CountForkJoinTask(counted, 0, 1000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        Long res = forkJoinPool.invoke(task);

//        do {
//            System.out.printf("Main: Thread Count: %d\n", forkJoinPool.getActiveThreadCount());
//            System.out.printf("Main: Thread Steal: %d\n", forkJoinPool.getStealCount());
//            System.out.printf("Main: Parallelism: %d\n", forkJoinPool.getParallelism());
//            try {
//                TimeUnit.MILLISECONDS.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        } while (!task.isDone());

        forkJoinPool.shutdown();
        System.out.println("-----DONE----" + res.toString());
    }

}
