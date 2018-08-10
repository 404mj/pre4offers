package com.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-4-24
 * <p>
 * largest contiguous array sum
 * 最大子串和问题
 * 连续数组子串和问题
 * 也叫 最大序列 问题!!
 * <p>
 * given the array [−3,7,−1,2,1,−5,4]
 * the contiguous subarray [4,−1,2,1] has the largest sum = 9
 * https://blog.csdn.net/derrantcm/article/details/46736967
 */
public class MaxSubarray {
    public static void main(String[] args) {
        MaxSubarray m = new MaxSubarray();
        int[] nums = {-3, 7, -1, 2, 1, -5, 4};
        m.solve2(nums);
    }

    /**
     * 我自己的思路:一次把每个数之前的元素加起来, 和最大的index为anser的end,
     * 往前找到和最小的index为start.中间即结果!
     * ===>以上思路有问题!
     *
     */

    /**
     * 只求最大和, 暂时不负责具体结果内容.
     * 网上解答:使用动态规划
     * http://www.cnblogs.com/xwdreamer/archive/2012/05/04/2482507.html
     * <p>
     * <b> 发现动态规划主要是两种类型:1.一组数据进行操作, 2.两组数据进行操作
     * => 每组问题对应两种考虑套路: 1.c(i):第i个元素用不用? 2.c(i):到第i个元素为止的前边的结果  ==>(i,j)同理
     * </b>
     * 状态转移方程::f(i)表示以nums[i]结尾的连续子数组的最大和,
     * ==>
     * if f(i-1) > 0   f(i) = f(i-1) + nums[i]
     * if f(i-1) <= 0  f(i) = nums[i]
     */
    public void solve2(int[] nums) {
//        int[] res = new int[nums.length];
//        int k = 0; //维护结果数组index
        int premax = nums[0];//前部分最大和结果
        int max = premax;

        for (int i = 1; i < nums.length; ++i) {
            if (premax > 0) {
                premax += nums[i];
                max = (premax > max) ? premax : max;
//                res[k++] = nums[i];
            } else {
                premax = nums[i];
                max = (premax > max) ? premax : max;
                //清理残留值
//                for (; k > 0; k--) {
//                    res[k] = 0;
//                }
//                res[k] = nums[i];
//                k++;
            }
        }
        System.out.println("max add is: " + max + " the details is: ");
//        for (int e : res) {
//            System.out.print(" " + e);
//        }
    }
    /**
     * 写代码,错误百出!!!还是得训练啊!!!
     */


}
