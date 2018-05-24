package io.github.algorithms.Sword2Offer;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by zsx at 18-4-24
 * <p>
 * 最长的没有重复字符的子串
 * 竟然忘了, 我草!
 * (
 *      对每一个题, 都将其视为会问到! 会用到!保持大脑惊醒和高校!
 * )
 */
public class LongestSubStrWitoutRepeat {
    public static void main(String[] args) {
        LongestSubStrWitoutRepeat l = new LongestSubStrWitoutRepeat();
//        String s = "pwkkeuiw";
        String s = "abeef";
        int ans = l.solve(s);
        System.out.println(ans);
    }

    /*
     * 滑动窗口,hash
     * sliding window
     * 参考: https://leetcode.com/articles/longest-substring-without-repeating-characters/
     */
    public int solve(String s) {
        int n = s.length();
        Set<Character> set = new LinkedHashSet<>(); // 保持插入顺序

        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        System.out.println(set);//**NOTE:**并不能保存结果!
        return ans;
    }
}
