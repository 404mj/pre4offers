package com.github.algorithms.Sword2Offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zsx at 18-5-14 下午10:03
 *
 * 输入一个正整数数组，将它们连接起来排成一个数，输出能排出的所有数字中最大(小)的一个
 * given   [3, 32, 321]
 * expect  321323
 *
 */
public class IntArrayMaxCombination {
    public static void main(String[] args) {
        IntArrayMaxCombination imc = new IntArrayMaxCombination();
        int[] nums = {3, 32, 321};
        imc.solve(nums);
    }

    /**
     * 思路::把数组排序, 输出即可,
     * 排序规则要按照两个String大小
     * 先拼接起来, 比较ab和ba哪个大
     *
     * 参考: https://www.nowcoder.com/questionTerminal/8fecd3f8ba334add803bf2a06af1b993?source=relative
     *
     * 因为Integer会越界, 所以需要把Integer转换为String
     *
     * @param nums
     */
    public void solve(int[] nums) {

        //使用java8 API!!!
        List<Integer> lNums = Arrays.stream(nums).boxed().collect(Collectors.toList());

        Collections.sort(lNums, ( o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o1 + "" + o2;
            return s1.compareTo(s2);
        });

        StringBuffer buffer = new StringBuffer();
        lNums.forEach(e -> buffer.append(e));

        System.out.println("res is: " + buffer.toString());
    }


}
