package com.github.algorithms.Sword2Offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by zsx at 18-4-24
 * <p>
 * 求数组中 **第k大** 的数字
 * 0.常规排序取值
 * 1.基于快排
 * 2.计数排序,
 * 3.堆排序
 *
 * ------
 * 还有一个问题是: 最小的K个数,, 思路差不多!!
 */
public class KthInArray {
    public static void main(String[] args) {
        KthInArray ki = new KthInArray();
        int[] nums = {4, 3, 1, 9, 12, 7, 18};
        int k = 3;
//        ki.solveUseHeap(nums, k);
//        ki.solveUseHeap2(nums, k);
//        ki.solveUseSort(nums, k);
        ki.solveUseQuick(nums, k);
    }

    /**
     * 最基本的思路:先排序,
     *
     * @param nums
     */
    public void solveUseSort(int[] nums, int k) {
        //check parameter

        final int n = nums.length;
        Arrays.sort(nums);

        System.out.println(nums[n - k]);
    }

    /**
     * 了解一下PriorityQueue工作原理: http://www.cnblogs.com/CarpenterLee/p/5488070.html
     * 使用堆
     *
     * @param nums
     */
    public void solveUseHeap(int[] nums, int k) {
        //check parameters

        //从大到小
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);

        Arrays.stream(nums).forEach(e -> heap.offer(e));

        for (int i = 0; i < k - 1; ++i) {
            heap.poll();
        }

        System.out.println(heap.peek());
    }

    /**
     * 另外一种写法, 理解PriorityQueue特性
     *
     * @param nums
     * @param k
     */
    public void solveUseHeap2(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int i : nums) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }
        System.out.println(q.peek());
    }

    /**
     * 快排序思路解决
     * 自己实现的.
     * 可以参考: https://aaronice.gitbooks.io/lintcode/content/data_structure/kth_largest_element.html
     * @param nums
     */
    public void solveUseQuick(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public void quickSelect(int[] nums, int start, int end, int kth) {
        int i = start, j = end;
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;

            while (i < j && nums[i] <= pivot) i++;

            //交换
            nums[i] = nums[j] + nums[i];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[j] - nums[i];
        }
        nums[start] = nums[j];
        nums[j] = pivot;

        //根据k和现在确定的位置j, 决定去哪部分递归select
        if (kth > j) {
            quickSelect(nums, j + 1, end, kth);
        } else if (kth < j) {
            quickSelect(nums, start, j - 1, kth);
        } else {
            System.out.println("found: " + nums[j]);
        }

    }

}
