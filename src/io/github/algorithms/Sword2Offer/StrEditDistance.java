package io.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-5-3 上午11:36
 * <p>
 * 字符串编辑距离
 * 只允许三种操作: 替换, 删除, 插入
 * 从一个字符串=>到另一个使用以上操作的最少步骤!
 * c(i,j)表示字符串x长度为i,字符串y长度为j,x变为y所需要的步骤数::
 * if x[i] == y[j]                               c(i,j) = c(i-1,j-1)
 * if x[i] != y[j]  **insert**  y[j] in x[i]     c(i,j) = c(i,j-1) + 1
 * if x[i] != y[j]  **delete**  x[i]             c(i,j) = c(i-1,j) + 1
 * if x[i] != y[j]  **replace** x[i] with y[j]   c(i,j) = c(i-1,j-1)+1
 */
public class StrEditDistance {

    public static void main(String[] args) {
        StrEditDistance sed = new StrEditDistance();
        String x = "vintner";
        String y = "writers";
        sed.solve(x, y);
    }

    /**
     *
     * @param x
     * @param y
     */
    public void solve(String x, String y) {
        int lenx = x.length();
        int leny = y.length();

        int[][] c = new int[lenx + 1][leny + 1];
        for (int i = 0; i <= lenx; ++i) {
            c[i][0] = i;
        }
        for (int j = 0; j <= leny; ++j) {
            c[0][j] = j;
        }

        for (int i = 0; i < lenx; ++i) {
            char c1 = x.charAt(i);
            for (int j = 0; j < leny; ++j) {
                char c2 = y.charAt(j);

                if (c1 == c2) {
                    c[i + 1][j + 1] = c[i][j];
                } else {
                    int replace = c[i][j] + 1;
                    int insert = c[i][j + 1] + 1;
                    int delete = c[i + 1][j] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    c[i + 1][j + 1] = min;
                }
            }
        }
        System.out.println("edit: " + c[lenx][leny]);
    }
}
