package com.github.clazzloader.wiki;

/**
 * Author: fengchen.zsx
 * date: 2018/7/19 19:05
 */
public class Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();

        try {
            demo.getClass().getClassLoader().loadClass("com.github.algorithms.Sword2Offer.KthInArray");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
