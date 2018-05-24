package io.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-5-2
 * <p>
 * 最长公共 **子序列** !
 * 两个字符串:x, y. x.length > y.length
 * abacbaeg
 * babg
 * DP:状态转移方程::状态转移方程c(i,j)表示以x[i]和y[j]结尾的最长公共子序列
 * ==>
 * if  i=0 or j=0      c(i,j) = 0
 * if  x[i] != y[j]    c(i,j) = max(c[i-1][j], c[i][j-1])
 * if  x[i] == y[j]    c(i,j) = c(i-1,j-1) + 1
 * 最后 max(c(i,j)) 即为所求
 */
public class LongestCommonSubSeq {

    public static void main(String[] args) {
        LongestCommonSubSeq l = new LongestCommonSubSeq();
        String x = "abacbaeg";
        String y = "azbg";
        System.out.println(l.solve(x, y));
//        l.solveWithRes(x, y);
    }

    /**
     * 只求出长度, 空间复杂度有点大
     * <p>
     * 构造这个二维矩阵的过程中由于得出矩阵的某一行后其上一行就没用了，所以可以用一维数组来代替这个矩阵。
     * 减少空间复杂度!
     * <p>

     */
    public int solve(String x, String y) {
        int[][] c = new int[x.length() + 1][y.length() + 1];
        //因为传递的是基本数据类型, 所以不需要回传就生效了!
        constructMatrix(x, y, c);
        return c[x.length()][y.length()];
    }

    /**
     * 求具体的最长公共子序列的值!
     *
     * @param x
     * @param y
     */
    public void solveWithRes(String x, String y) {
        //构造二维数组
        int[][] c = new int[x.length() + 1][y.length() + 1];
        constructMatrix(x, y, c);

        // 根据二维数组回溯打印结果!!!
        int i = x.length(), j = y.length();
        StringBuffer sbuf = new StringBuffer();
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                sbuf.append(x.charAt(i - 1));
                i--;
                j--;
            } else if (c[i][j - 1] >= c[i - 1][j])
                j--;
            else
                i--;
        }
        System.out.println(sbuf.reverse().toString());
    }

    /**
     *
     * <b>核心!!</b>
     * 根据状态转移方程具体构造二维数组!!
     *
     * 一个多了一行和一列的二维数组.
     * 对x, y的访问从0开始, 但是映射到二维数组从1开始
     * (这是编程实现上的策略, 否则按照算法构造, 在一开始i-1和j-1取不到对应的值)
     */
    private void constructMatrix(String x, String y, int[][] c) {
        for (int i = 1; i <= x.length(); ++i) {
            for (int j = 1; j <= y.length(); ++j) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) c[i][j] = c[i - 1][j - 1] + 1;

                else if (x.charAt(i - 1) != y.charAt(j - 1)) c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
            }
        }
    }
}
