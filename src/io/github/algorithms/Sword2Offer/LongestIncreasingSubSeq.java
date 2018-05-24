package io.github.algorithms.Sword2Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zsx at 18-5-3 上午10:49
 * lonngesg increasing sub sequence
 * 最长递增 **子序列**
 * given   [1, 5, 3, 9, 4, 6, 7]
 * answer  [1, 3, 4, 6, 7]
 */
public class LongestIncreasingSubSeq {

    public static void main(String[] args) {
        LongestIncreasingSubSeq lis = new LongestIncreasingSubSeq();
        int[] nums = {1, 5, 3, 9, 4, 6, 7};
        lis.solve2(nums);
    }

    /**
     * 自己思考: 用DFS似乎也可以解决!还有就是DP.
     */

    /**
     * https://blog.csdn.net/u013178472/article/details/54926531
     * https://www.programcreek.com/2014/04/leetcode-longest-increasing-subsequence-java/
     * <p>
     * 1. 转化为最长公共子序列
     * 2. DP O(n^2)
     * 3. DP O(nlgn)
     * 使用动态规划的思想:::
     * ===>c(i)表示以nums[i]结尾的最长递增子序列
     * c(i) = max(c(j)+1) <=> if nums[i] > nums[j] and j < i
     * 所以就要对没一个i, 求在其前边的小于它的并且c(i)最大的,维护一个数组记录index对应的c(i)
     *
     * @param nums
     */
    public void solve(int[] nums) {
        if (nums == null || nums.length == 0) throw new NullPointerException();

        int[] max = new int[nums.length];
        Arrays.fill(max, 1);

        int res = 1;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);
                }
            }
            res = Math.max(max[i], res);
        }
        System.out.println("res is " + res);
    }

    /**
     * 另外一种解决方案: 把没一个元素放到res里, 如果它比最后一个大就放,
     * 否则就替换掉比它大的最小值.
     *
     * @param nums
     */
    public void solve2(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new NullPointerException();

        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            if (res.size() == 0 || num > res.get(res.size() - 1)) {
                res.add(num);
            } else {
                //二分查找插入
                //我自己想到的这种二分,只记录中间middle
                int mid = (res.size() - 1) / 2;
                while (mid >= 0 && mid < res.size() - 1) {
                    if (num < res.get(mid)) {
                        mid = mid / 2;
                    } else {
                        mid = (mid + res.size()) / 2;

            //普通的二分
                        /*
                int i=0;
                int j=res.size()-1;

                while(i<j){
                    int mid = (i+j)/2;
                    if(res.get(mid) < num){
                        i=mid+1;
                    }else{
                        j=mid;
                    }
                    */
                    }
                }
                res.set(mid, num);
            }
        }
//        System.out.println(res.size());
        res.forEach(e -> System.out.println(e));
    }
}
