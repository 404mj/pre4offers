package com.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-5-14 下午7:34
 * <p>
 * 求str中至少包含k个重复字符的最长字串!!
 * 这些Longest***其实都是要长度,,没有要结果, 这就对求解简单了一点!!!
 *
 * given : ababbc k=2
 * expect: ababb ==> 5
 */
public class LongestSubstrWithAtLeastKRepeat {
    public static void main(String[] args) {
        LongestSubstrWithAtLeastKRepeat ls = new LongestSubstrWithAtLeastKRepeat();
        String s = "ababbc";
        int k = 2;
        ls.solve(s, k);
    }

    /**
     * 分治法.
     * 首先统计str[i--j]之间的词频,然后,针对词频结果找到第一个 重复出现了 and 出现次数<k的位置pos, i到j之间肯定不能包含pos,不满足条件.
     * 以pos分两部分, 递归求出两者的最大即为所求!
     * <p>
     * 1. https://leetcode.com/problems/longest-substring-with-at-least-k-
     * repeating-characters/discuss/87741/Java-divide-and-conquer(recursion)-solution
     * 2. https://blog.csdn.net/u010900754/article/details/62159601
     * <p>
     * 总结子串问题无非是:
     * 1. 滑动窗口
     * 2. DP
     * 3. 分治!
     *
     * @param source
     */
    public void solve(String source, int k) {
        //check parameters....
        int res = solveDC(source.toCharArray(), 0, source.length(), k);
        System.out.println(res);
    }
    private int solveDC(char[] chars, int start, int end, int k) {
        //取词频
        int[] wf = new int[26]; //wf stands for word frequency
        for (char c : chars) {
            wf[c - 'a']++;
        }

        //divide and conquer operation
        for (int i = 0; i < 26; ++i) {
            if (wf[i] > 0 && wf[i] < k) {
                //求这个 "坏"字符的 pos, 用index更方便, 本质不变
                for (int j = start; j < end; ++j) {
                    if (chars[j] == i+'a') {
                        int left  = solveDC(chars, start, j, k);
                        int right = solveDC(chars, j + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }

    /**
     * 这个答案没看懂!!
     * https://leetcode.com/problems/longest-substring-with-at-least-
     * k-repeating-characters/discuss/87739/Java-Strict-O(N)-Two-Pointer-Solution?page=2
     */
}
