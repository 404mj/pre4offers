package io.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-6-2 下午8:50
 * <p>
 * 给定整数n, m, 求 **1--n** 之间
 * 按照 **字典顺序** 排列的第m个数! (n可能为5000000)
 * <p>
 * 首先一开始对数字的字典序有点mengbi, 其实字符的排序自然就是字典序, 所以就是把数字转为string
 * 就可以按照自然的字典序了.treeset, list都可以....
 * <p>
 * 当然还有就是自定义comparator.....ref:https://blog.csdn.net/caoxiaohong1005/article/details/78596297
 * <p>
 * 但是n可能很大, 自然会有溢出风险!!!
 */
public class NumberSortbyDictOrder {
    public static void main(String[] args) {
//        String a = "12";
//        String b = "13";
//        System.out.println(a.compareTo(b));
        NumberSortbyDictOrder nsd = new NumberSortbyDictOrder();
//        nsd.standradSolve(150, 5);
//        nsd.standradSolve(15,5);
        nsd.standradSolve(9, 5);

    }


    public void simpleSolve(int n, int m) {

    }

    /**
     * reference: https://blog.csdn.net/caoxiaohong1005/article/details/78681450
     *
     * 防止内存溢出的"标准解法",解释的看不懂,
     * 看代码才理解了点!!.....
     * @param n
     * @param m
     */
    public void standradSolve(int n, int m) {
        //分析数字规律!!
        /**
         * 按字典序都是从1开始, 然后10,(11,12....) 100,(101,102....)
         * 所以先从大了算出能表示的范围, 如果比m大,res扩大一个10倍再表示范围和m比较
         * 如果m大, 说明范围对了, 需要更精细的找, 只需要让res一个一个的增加就行.对应上面的(11,12....)
         */
        long res = 1;
        m--;
        while (m != 0) {
            long num = 0;
            long start = res, end = res + 1;
            while (start <= n) {
                num += Math.min(n + 1, end) - start;//[start,end)这个范围内可以有多少个数字
                start *= 10;
                end *= 10;
            }
            if (num > m) { //可以表示的数字个数比还需要计算的数字个数小,也就是通过在res后面补0进行范围查找.
                res *= 10;
                m--;//res*10作为此次找到的第一个数字,故还需要计算的数字个数需要减一
            } else {
                //需要查找的数字个数比当前范围的数字个数大
                // 那么res++更改前缀,从而更改范围;
                // 同时m还需要减去当前范围内已经找到的数字个数num.
                m -= num;
                res++;
            }
        }
        System.out.println(res);
    }
}
