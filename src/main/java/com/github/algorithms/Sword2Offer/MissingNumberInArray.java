package com.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-5-28 下午9:34
 *
 * 给定一个无序的int数组. 找到里面第一个不存在的, 并且是大于0的数字
 * example: [5,-1,3,4,1]
 * expect:  2
 *
 * 要求:timeO(n) spaceO(1)
 *
 * 方案很多, 要保证O(1)的空间,不容易, set,map,数组的方式都pass掉了
 *
 * ref https://blog.csdn.net/morewindows/article/details/12683723
 * 1: 使用基数排序的思想:
 *  原地进行判断,如果是2交换到2的位置上去.最后遍历一遍如没,则为所求!
 *
 * ref: https://www.geeksforgeeks.org/find-the-missing-number/
 * 2. 根据都有的假设求1--n的和,然后再减去实际数值.(要注意int溢出的情况!)
 *
 * 3. 还是异或啊!!
 *
 * 4. 如果缺失的不止一个的话:在java中可以使用BitSet
 * ref: https://javarevisited.blogspot.com/2014/11
 * /how-to-find-missing-number-on-integer-array-java.html
 *
 */
public class MissingNumberInArray {
    public static void main(String[] args) {
        int[] nums = {5, -1, 3, 4, 1};
        MissingNumberInArray mni = new MissingNumberInArray();
        mni.solve(nums);
    }

    /**
     *
     * @param nums
     */
    public void solve(int[] nums) {

    }
}
