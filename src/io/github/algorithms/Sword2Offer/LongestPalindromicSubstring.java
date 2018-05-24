package io.github.algorithms.Sword2Offer;

import java.util.StringJoiner;

/**
 * Created by zsx at 18-5-3 下午4:05
 * 最长回文子串!
 * http://www.cnblogs.com/TenosDoIt/p/3675788.html
 * https://juejin.im/entry/58c7c297da2f605dc5b3d139
 * <p>
 * given:  bablevelbagalbc
 * expect: ablevelba
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        char[] chars = {'b', 'a', 'b', 'l', 'e', 'v', 'e', 'l', 'b', 'a', 'g', 'a', 'l', 'b', 'c'};//15==>9
//        char[] chars = {'b', 'a', 'a', 'b'};//4==>4
        lps.solveFix(chars);
    }

    /**
     * 自己的方法: 中心扩展!
     * 其实除了动态规划, 其他方法的核心思想都是中心扩展!
     * <p>
     * 暴力方法也不用O(n^3)吧
     *
     * @param chars
     */
    private int solve(char[] chars) {
        //check parameter

        int max = 0;
        for (int i = 1; i < chars.length; ++i) {
            //每个字符左右延伸的广度
            int count = 0;
            int k = Math.min(i, chars.length - 1 - i);
            for (int j = 1; j <= k; ++j) {
                if (chars[i - j] == chars[i + j]) {
                    count++;
                }else
                    break;
            }
            max = (count > max) ? count : max;
        }
//        System.out.println("max phlindromic length is : " + (2*max + 1));

        // 学到一个快捷键:C + S + Enter ,"为您收尾"   from: https://blog.csdn.net/linsongbin1/article/details/80211919
        return max / 2;
    }

    /**
     * * ---update----*
     * 忽略了一种情况即使第二个chars中baab也是一种回文串,只不过没有显示的使用那个字符作为中心
     * <p>
     * 因此将每个字符之间插入一个符号,进行标记空隙!
     *
     * @param chars
     */
    public void solveFix(char[] chars) {
        //check parameters
        StringJoiner sj = new StringJoiner("-");
        for (char c : chars) {
            sj.add(String.valueOf(c));
        }
        char[] chars1 = sj.toString().toCharArray();
        int res = solve(chars1);
        System.out.println(res*2+1);
    }

    /**
     * 使用动态规划解决,
     * 也可以住转化为LCS
     * 状态转移方程:::    c(i,j)表示chars[i]到chars[j]之间的最长回文子串
     * if chars[i] == chars[j]  c(i,j) = c(i+1, j+i-1) + 2
     * if chars[i] != chars[j]  c(i,j) = max(c(i+1,j), c(i,j+i-1))
     *
     * @param chars
     */
    public void solveDp(char[] chars) {

    }


}
