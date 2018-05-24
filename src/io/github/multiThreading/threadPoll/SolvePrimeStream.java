package io.github.multiThreading.threadPoll;

import java.util.*;

/**
 * Created by zsx at 18-4-6
 */
public class SolvePrimeStream {

    static boolean isPrime(Integer num) {
        for (int i = 2; i<= num /2; ++i) {
            if ((num % i) == 0) return  false;
        }
        return true;
    }

    static class Person {
        String name;
        Integer age;

        Person(String name, Integer age) {
            this.name = name;
            this.age  = age;
        }

    }

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        Random r = new Random();
        for (int i= 0; i< 10000; ++i) nums.add(1000000 + r.nextInt(1000000));

        long start = System.currentTimeMillis();
        nums.forEach(v -> isPrime(v));
        long end = System.currentTimeMillis();
        System.out.println("串行Stream： "+ (end - start));

        start = System.currentTimeMillis();
        nums.parallelStream().forEach(SolvePrimeStream::isPrime);
        end = System.currentTimeMillis();
        System.out.println("并行Stream：" + (end - start));
    }
}
