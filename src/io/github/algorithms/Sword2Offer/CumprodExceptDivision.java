package io.github.algorithms.Sword2Offer;

import java.util.Arrays;

/**
 * Created by zsx at 18-6-2 下午4:24
 * <p>
 * cumulative product累乘
 * 整数数组a,和b, 对b中的每个元素都有:
 * b[j] = a[0]*a[1]*...a[n-1] / a[j]
 * 根据a构造b, 但是不能使用除法, 保证O(n)time和O(1)space
 * 不能使用其他变量
 * <p>
 * <p>
 * 分析: 因为不能使用除法, 肯定是分析每个元素之见的关系, 累计的计算.
 * ref:https://blog.csdn.net/morewindows/article/details/8742666
 * <p>
 * 思路:遍历两遍，第一遍正向计算被a[j]分隔的前半部部分, 第二遍从后往前累计上第一遍的结果将
 * 后半部分计算出来.
 */
public class CumprodExceptDivision {
    public static void main(String[] args) {
        CumprodExceptDivision ced = new CumprodExceptDivision();
        int[] a = {1, 2, 4, 7, 3, 6};
        ced.sovle(a);
    }

    /**
     * @param a
     */
    public void sovle(int[] a) {
        //check parameters

        int[] b = new int[a.length];

        //第一遍遍历,
        b[0] = 1;
        for (int i = 1; i < a.length; ++i) {
            b[i] = b[i - 1] * a[i - 1];
        }

        //第二遍
        int tmp = 1;//保留向上累加的乘数
        for (int i = a.length - 2; i >= 0; --i) {
            tmp *= a[i + 1];
            b[i] = b[i] * tmp;
        }

        //打印结果:
        Arrays.stream(b).forEach(System.out::println);
    }
}
