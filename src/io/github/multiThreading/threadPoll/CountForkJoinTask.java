package io.github.multiThreading.threadPoll;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * Author: fengchen.zsx
 * date: 2018/6/18 22:14
 */
public class CountForkJoinTask extends RecursiveTask<Long> {

    //默认每个task计算10个元素
    private static final int STEP = 10;

    private int[] counted;
    private int first;
    private int last;

    public CountForkJoinTask(int[] counted, int first, int last) {
        this.counted = counted;
        this.first = first;
        this.last = last;
    }

    @Override
    protected Long compute() {

        //满足条件执行任务
        if ((last - first) <= 10) {
            Long sum = 0L;
            for (int i = first; i < last; i++) {
                sum += counted[i];
            }
            return sum;
        } else {
            // 先分割任务在提交执行
            int middle = (last + first) / 2;
            System.out.printf("Task: Pending tasks:%s\n", getQueuedTaskCount());
            CountForkJoinTask t1 = new CountForkJoinTask(counted, first, middle + 1);
            CountForkJoinTask t2 = new CountForkJoinTask(counted, middle + 1, last);

            /**
             * 这样是最好的，不能单独自己fork，
             * 原因: https://www.liaoxuefeng.com/article/001493522711597674607c7f4f346628a76145477e2ff82000
             */
            invokeAll(t1, t2);

            Long res1 = t1.join();
            Long res2 = t2.join();

            return res1 + res2;
        }
    }
}
