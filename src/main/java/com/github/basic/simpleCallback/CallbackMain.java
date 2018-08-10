package com.github.basic.simpleCallback;

/**
 * Created by zsx at 18-5-14 上午9:47
 *
 * 简单的同一JVM下的回调实现,
 * 更多的是实现方式上的设计模式.
 *
 * 学了golang之后对,java的interface理解更深入了.
 *
 */
public class CallbackMain {
    public static void main(String[] args) {
        Worker w = new Worker();
        Boss b = new Boss(w);

        b.dispatchWork();

    }
}
