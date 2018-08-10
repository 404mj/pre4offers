package com.github.basic.simpleCallback;

/**
 * Created by zsx at 18-5-14 上午9:47
 */
public class Boss implements ICallbackReport {

    private Worker worker;

    public Boss(Worker worker) {
        this.worker = worker;
    }

    public void dispatchWork() {
        new Thread(() -> {
            worker.work(Boss.this);
        }).start();
    }

    @Override
    public void report(String msg) {
        System.out.println("Worker Call Back arrived at Boss!--> " + msg);
    }

}
