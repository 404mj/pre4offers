package com.github.basic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by zsx at 18-5-10 上午10:56
 *
 * List转换为Map的几种方法:
 * 1. 循环设置
 * 2. Guava
 * 3. java8 Collectors
 *
 */
public class List2MapWays {
    public static void main(String[] args) {
        List<String>  list = new ArrayList<>(Arrays.asList("zhangSan", "liSi", "wangWu", "zhaoLiu"));

//        list.forEach(System.out::println);
//        Map<Integer, String> maps = list.stream().collect(Collectors.toMap(list.indexOf(), ));

    }
}
