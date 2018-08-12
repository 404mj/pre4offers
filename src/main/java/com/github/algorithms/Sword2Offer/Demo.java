package com.github.algorithms.Sword2Offer;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zsx at 18-4-22
 */
public class Demo {
    public static void main(String[] args) {
//        Demo d = new Demo();

//        String[] cols = {"codecode", "descdesc", "2123.2323,2313.2132"};
//        String colss = Arrays.stream(cols).collect(Collectors.joining("','", "('", "')"));
//        Arrays.stream(colss).forEach(System.out::println);
//        System.out.println(colss);

        /*
//        String str = "google";
        String str = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : chars) {
            Integer ct = map.getOrDefault(c, 0);
            map.put(c, ++ct);
        }

        int index = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(str.indexOf(entry.getKey()));
                return;
            }
            index += entry.getValue();
        }
        System.out.println(-1);
        */

        /*
        int[] nums = {3, 32, 321};
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numList, (e1, e2) -> {
            String s1 = e1 + "" + e2;
            String s2 = e2 + "" + e1;
            return s1.compareTo(s2);
        });
        String sb = numList.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(sb);
        */




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
