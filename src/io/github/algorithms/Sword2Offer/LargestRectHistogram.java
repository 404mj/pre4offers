package io.github.algorithms.Sword2Offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by zsx at 18-4-24
 * 柱形图中最大举行面积
 *
 * 牛客网上的讨论:: https://www.nowcoder.com/questionTerminal/13ba51c3fec74b58bbc8fa8c3eedf877
 *
 *
 */
public class LargestRectHistogram {

    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {2, 5, 4, 6, 3, 2};
        LargestRectHistogram l = new LargestRectHistogram();
//      l.bruteGet(heights);
//        l.stackGet(heights);
        l.bruteWithPruning(heights);

    }

    /**
     * 我的方案:暴力循环, 顺序求最大
     */
    public void bruteGet(int[] hist) {
        int minele;
        int maxArea = -1;

        for (int i = 0; i < hist.length - 1; ++i) {
            minele = hist[i];
            for (int j = i + 1; j < hist.length; ++j) {
                if (hist[j] < minele) minele = hist[j];

                maxArea = (minele * (j - i + 1) > maxArea) ? (minele * (j - i + 1)) : maxArea;
            }
        }
        System.out.println(maxArea);
    }

    /**
     * 增加剪枝操作
     *
     * @param hist
     */
    public void bruteWithPruning(int[] hist) {
        int area = 0;
        for (int i = 0; i < hist.length; i++) {
            for (int k = i + 1; k < hist.length; k++) {
                if (hist[k] < hist[k - 1]) {
                    i = k - 1;
                    break;
                } else {
                    i = k;
                }
            }
            int lowest = hist[i];
            for (int j = i; j >= 0; j--) {
                if (hist[j] < lowest) {
                    lowest = hist[j];
                }
                int currArea = (i - j + 1) * lowest;
                if (currArea > area) {
                    area = currArea;
                }
            }
        }
        System.out.println(area);
    }


    /**
     * 另外一种思路,利用两个栈一个放元素一个放递增的索引
     * 更巧妙的是用一个栈放索引就行!
     * 暂时不是很懂
     *  https://qht1003077897.github.io/2017/07/04/算法-直方图中的最大矩形/
     *  明白点了,连续递增,
     *
     * @param height
     * @return
     */
    public void stackGet(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxArea = 0;
        int[] h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length) {
            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        System.out.println(maxArea);
    }


    /**
     * 动态规划解决方案:
     * https://blog.csdn.net/li563868273/article/details/51121169
     *
     *
     * @param height
     */
    public void dpGet(int[] height) {

    }

}
