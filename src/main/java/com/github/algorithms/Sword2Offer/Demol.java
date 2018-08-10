package com.github.algorithms.Sword2Offer;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by zsx at 18-4-22
 */
public class Demol {
    public static void main(String[] args) {
//        Demo d = new Demo();

        String[] cols = {"codecode", "descdesc", "2123.2323,2313.2132"};
        String colss = Arrays.stream(cols).collect(Collectors.joining("','", "('", "')"));
//        Arrays.stream(colss).forEach(System.out::println);
        System.out.println(colss);
    }


    /**
     * 旋转数组的最小数字
     */
    public int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0) return 0;
        for (int i = 0, j = i + 1; i < len - 1 && j < len; ++i, ++j) {
            if (array[j] < array[i]) {
                return array[j];
            }
        }
        return array[0];
    }

    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }


}
