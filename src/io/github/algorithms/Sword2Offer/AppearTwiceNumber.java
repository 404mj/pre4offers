package io.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-5-19 下午9:10
 * 参考: https://www.cnblogs.com/youxin/p/3349834.html
 * <p>
 * 与AppearOnlyOnceNumber类似.
 * 如果依次^,结果是两个只出现一次的数的^结果, 肯定不是0, 那么这个结果二进制中最先为1的
 * <p>
 * 是第n位. 判断nums中第n位是不是1将nums分为两部分.
 * <p>
 * 然后依次^即可! 实现见solve方法!
 */
public class AppearTwiceNumber {
    public static void main(String[] args) {
        //=>结果显然应该是5, 7
        int[] nums = {1, 5, 9, 12, 1, 12, 7, 9};
        AppearTwiceNumber atn = new AppearTwiceNumber();
        atn.solve(nums);
    }

    /**
     * @param nums
     */
    public void solve(int[] nums) {
        //check parameters...

        int tmp = 0;
//        Arrays.stream(nums).forEach(e -> res1 ^= e);//这样使用lambda是错误的, 不允许在lambda里面修改数据
        for (int num : nums) {
            tmp ^= num;
        }

        /**
         * find first bit set...
         * 可以当个小算法题了...
         * 1. x & 1 << k == 0|1
         * 2. Integer.numberOfTrailingZeros() + pos == 33 ? -1 : pos
         * 3. C++ : fff() and ffs()
         */
        int idxOf1 = Integer.numberOfTrailingZeros(tmp) + 1;

        /**
         * check specific k-th bit is set??
         * 又可以当个小算法题...:)
         * 1. x >> (k-1) & 1
         * 2. (x & 1 << (k-1)) >= 1 SET
         */
        //边分组边计算结果吧...
        int res1 = 0, res2 = 0;
        for (int num : nums) {
            if ((num & (1 << (idxOf1 - 1))) >= 1) {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }
        System.out.println("There are: " + res1 + ", " + res2);
    }
}
