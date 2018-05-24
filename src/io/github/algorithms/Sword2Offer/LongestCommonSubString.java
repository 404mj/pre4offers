package io.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-5-2
 * http://www.cnblogs.com/zhangchaoyang/articles/2012070.html  好文章
 * 最长公共 **子串** ::
 * 两个字符串x y x长度>y
 * abacbaeg
 * babg
 * 1.暴力:求一个字符串的所有子串.
 * 2.DP:状态转移方程c(i,j)表示以x[i]和y[j]结尾的最长公共字串
 * ==>
 * if  i=0 or j=0      c(i,j) = 0
 * if  x[i] != y[j]    c(i,j) = 0
 * if  x[i] == y[j]    c(i,j) = c(i-1,j-1) + 1
 * 最后 max(c(i,j)) 即为所求
 */
public class LongestCommonSubString {


    public static void main(String[] args) {
        LongestCommonSubString l = new LongestCommonSubString();
        String x = "abacbaeg";
        String y = "baeg";
//        System.out.println(l.solution(x, y));
        l.solutionWithRes(x, y);
    }

    /**
     * <b>核心!!!</b>
     * <p>
     * 按照状态转移方程,构造二维求解数组!空间复杂度还大
     *
     * @param x
     * @param y
     * @param c
     */
    private void constructMatrix(String x, String y, int[][] c) {
        /*
         * 注意c数组和对两个数组的取值范围的选择
         * 其实就是空出0的位置来了
         * **但是** java String 默认是从0开始访问,
         * 所以访问的时候是从0开始访问, 映射到c二维ie数组上是对应的从一开始的
         * 最长公共子序列同理!就算是转换为char array 也是这样的!
         */
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i - 1) != y.charAt(j - 1)) c[i][j] = 0;

                else if (x.charAt(i - 1) == y.charAt(j - 1)) c[i][j] = c[i - 1][j - 1] + 1;
            }
        }
    }

    /**
     * 只求长度,
     */
    public int solution(String x, String y) {
        int[][] c = new int[x.length() + 1][y.length() + 1];
        constructMatrix(x, y, c);
        return c[x.length()][y.length()];
    }

    /**
     * 回溯二维数组, 输出具体的值
     *
     * @param x
     * @param y
     */
    public void solutionWithRes(String x, String y) {
        int[][] c = new int[x.length() + 1][y.length() + 1];
        constructMatrix(x, y, c);

        StringBuffer sbuf = new StringBuffer();
        int i = x.length(), j = y.length();
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                sbuf.append(x.charAt(i - 1));
                i--;
                j--;
            } else if (c[i - 1][j] >= c[i][j - 1]) {
                i--;
            } else
                j--;
        }
        System.out.println(sbuf.reverse().toString());
    }
}
