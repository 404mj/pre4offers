package io.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-5-13 下午7:20
 * <p>
 * 取int数组中出现次数为: 对 n/3下取整
 * 1.使用HashMap,but:空间复杂度O(n)
 * 2.better?
 */
public class MajorityElement2 {
    public static void main(String[] args) {

    }

    /**
     * better solution,
     * 由大于一半的方案改造: 满足大于[1/3]的数，应当小于等于2个
     * 所以维护两个candidate即可.
     *
     * 参考: https://aaronice.gitbooks.io/lintcode/content/high_frequency/majority_number_ii.html
     * @param nums
     */
    public void solve(int[] nums) {
        //check parameters...

        int r1 = -1, r2 = -1; // r1 stands for result-1
        int c1 = 0, c2 = 0;   // c1 stands for count-1

        for (int num : nums) {
            if (num == r1) {
                c1++;
            } else if (num == r2) {
                c2++;
            } else if (c1 == 0) {
                r1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                r2 = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        //确认候选是否满足条件
        c1 = c2 = 0;
        for (int num : nums) {
            if (num == r1) c1++;
            if (num == r2) c2++;
        }
        System.out.println(c1 > c2 ? r1 : r2);
    }
}
