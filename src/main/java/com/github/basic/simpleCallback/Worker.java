package com.github.basic.simpleCallback;

/**
 * Created by zsx at 18-5-14 上午9:47
 */
public class Worker {

    /**
     * 注意参数, 简单回调的重点
     * @param callObj
     */
    public void work(ICallbackReport callObj) {
        System.out.println("worker start working....");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        callObj.report("A MSG FROM WORDER U CALLED");
    }
}
