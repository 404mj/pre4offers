package io.github.multiThreading.threadPoll;

/**
 * Author: fengchen.zsx
 * date: 2018/6/18 10:30
 * <p>
 * ref: http://ifeve.com/java-threadpool/
 *
 * <p>
 *     java 线程池的体系如下: ref:  docs.oracle.com/javase/7/docs/api/java/util/concurrent/ForkJoinPool.html
 *     java.util.concurrent.AbstractExecutorService
 *        |                         |
 *     ForkJoinPool         ThreadPoolExecutor
 *                                   |
 *                          ScheduledThreadPoolExecutor
 * <p>
 * (都实现了Executor 和ExecutorService 接口)
 * 工具类java.util.concurrent.Executors
 */
public class ThreadPoolTraining {

    /**
     * 合理配置线程数量：
     * 任务的性质：CPU密集型任务（Ncpu+1个），IO密集型任务（2*Ncpu）和混合型任务。
     * <p>
     * 任务的优先级：高，中和低。
     * <p>
     * 任务的执行时间：长，中和短。
     * <p>
     * 任务的依赖性：是否依赖其他系统资源，如数据库连接。
     * 线程提交SQL后需要等待数据库返回结果，如果等待的时间越长CPU空闲时间就越长，那么线程数应该设置越大，这样才能更好的利用CPU
     */

    public static void main(String[] args) {

    }
}
