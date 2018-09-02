package com.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-5-18 下午9:58
 * <p>
 * 统计一个int数组中的逆序对的数量..
 * https://www.cnblogs.com/xwdreamer/archive/2012/10/12/2721938.html
 * <p>
 * 1. 常规做法O(n^2)
 * 2. 归并排序方案.
 * <p>
 * ----update2018-08-12----
 * 发现还是不会，说名之前就没理解
 * <p>
 * ------update2018-09-02-----
 * 线段树思路：http://www.ahathinking.com/archives/135.html
 * https://www.cnblogs.com/zhenglw/p/9507884.html
 * <p>
 * -------update2018-09-02 21:36---------
 * 没想到一个简单的题目这么复杂 ：
 * * https://www.luogu.org/problemnew/solution/P1908  使用桶排序，但是由于数量巨大，先进行离散化！！！-->也就是保存每个数是第几大！
 * <p>
 * 然后建立一个线段树！
 * https://blog.csdn.net/accepthjp/article/details/52301426 LeetCode出题难度频率汇总
 */
public class InversionsCount {
    int count = 0;

    public static void main(String[] args) {
        InversionsCount ic = new InversionsCount();
        int[] nums = {7, 5, 6, 4}; //expect:5
        ic.sovleMain(nums);
    }

    /**
     * 在进行归并的过程中, 如果两个元素,
     * 如果元素逆序就统计加一即可!
     * <p>
     * O(n lg n)
     */
    public void sovleMain(int[] nums) {
        int[] another = new int[nums.length];
        solve(nums, 0, nums.length - 1, another);
    }

    public void solve(int[] nums, int first, int last, int[] tmp) {
        if (first < last) {
            int mid = (first + last) / 2;
            solve(nums, first, mid, tmp);// 左边有序
            solve(nums, mid + 1, last, tmp); // 右边有序
            mergeArray(nums, first, mid, last, tmp); // 合并

        }
    }

    /**
     * 将两个有序序列合并！
     *
     * @param nums
     * @param first
     * @param mid
     * @param last
     * @param temp
     */
    public void mergeArray(int[] nums, int first, int mid, int last, int[] temp) {
        int i = first, j = mid + 1; // 两个游标！
        int k = 0;
        while (i <= mid && j <= last) {
            if (nums[i] > nums[j]) {
                // 左数组比右数组大
                temp[k++] = nums[j++];
                // 因为如果a[i]此时比右数组的当前元素a[j]大，
                // 那么左数组中a[i]后面的元素就都比a[j]大
                // 【因为数组此时是有序数组】
                count += mid - i + 1;
            } else {
                temp[k++] = nums[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= last) {
            temp[k++] = nums[j++];
        }
        for (i = 0; i < k; i++)
            nums[first + i] = temp[i];

        System.out.println("res : " + count);
    }

    /**
     * http://acm.xidian.edu.cn/problemset.php?page=1
     */
}
