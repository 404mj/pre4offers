package com.github.algorithms.Sword2Offer;

import java.util.Arrays;

/**
 * Created by zsx at 18-5-13 下午8:05
 * 取int数组中出现次数 n/2 的元素
 */
public class MajorityElement {
    public static void main(String[] args) {

    }

    /**
     * O(nlgn)
     *
     * @param nums
     */
    public void solve(int[] nums) {
        //check parameter
        if (nums.length == 1) {
            System.out.println(nums[0]);
            return;
        }

        Arrays.sort(nums);
        //出现次数超多一半的话, 必然出现在中间节点上!!!
        int res = nums[nums.length / 2];

        System.out.println(res);
    }


    /**
     * O(n) 解法!
     * https://www.programcreek.com/2014/02/leetcode-majority-element-java/
     * 就是我掌握的方法, 遍历一边, 对没一个元素,如果等于现在的, 出现次数+1, 否则-1. 等于0
     * 的时候换新的预测值
     *
     * @param nums
     */
    public void solveBetter(int[] nums) {
        int candidate = -1, count = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        //***NOTE***因为数组中可能根本不存在超多一般的元素, 所以需要确认操作,不要忽略!
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }
        if (count < (nums.length + 1) / 2) return;
        System.out.println("apperence half is : " + candidate);
    }
}
