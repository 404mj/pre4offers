package com.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-6-2 下午3:52
 *
 * 一个整数数组a,里面相邻两个元素只差都为1, 从其中查找制定的元素t的位置!
 *
 * input: {4,5,6,5,6,7,8,9,10,9} t=6
 * output:
 *
 * reference: https://blog.csdn.net/morewindows/article/details/10645269
 */
public class OneAbsArrayFind {
    public static void main(String[] args) {
        int[] nums = {4,5,6,5,6,7,8,9,10,9};
        OneAbsArrayFind oaf = new OneAbsArrayFind();
        oaf.solve(nums, 6);
    }

    /**
     *
     * @param nums
     * @param t
     */
    public void solve(int[] nums, int t) {
        //check parameters...

        int i = 0;
        while (i < nums.length && nums[i] != t) {
            i += Math.abs(nums[i] - t);
        }
        System.out.println("index = " + i);
    }
}
