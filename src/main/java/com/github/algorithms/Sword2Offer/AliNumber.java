package com.github.algorithms.Sword2Offer;

import java.util.Scanner;

/**
 * Created by zsx at 18-4-17
 */
public class AliNumber {


    //实现转换!阿拉伯数字转换为中文读音, 并且加停顿.
    static String tansform(long number) {
        String[] zhNums = {"零", "一", "二", "三","四","五","六","七","八","九"};
        String[] zhUnit = {"十","百","千", "万", "亿"};
        String numstr = Long.toString(number);
        String[] res = null;
        for (int i=0; i < numstr.length(); i += 4) {

        }


        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        long _number;
        _number = Long.parseLong(in.nextLine().trim());

        res = tansform(_number);
        System.out.println(res);
    }

}
