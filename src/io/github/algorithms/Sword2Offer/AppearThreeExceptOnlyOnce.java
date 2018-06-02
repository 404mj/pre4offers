package io.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-5-24 下午9:44
 * <p>
 * 同样是出现次数的问题,::int数组, 除了x之外, 其他都出现了三次
 * 找出x.
 * <p>
 * 分析: 因为是出现了三次, 就无法利用异或的特性了. 就无法采用前边使用的那种策略了.
 * 但还是要从位运算的角度去思考.
 * <p>
 * 如果所有元素都是出现三次, 那么,每个位上的1的和应该可以整除3!
 * ==>
 * 1. 如果计算得到某一位上的1的个数可以被3整除,那x在该位上肯定是0, 如果是1, 必然整除不了.
 * 2. 如果计算得到某一位上的1的个数不能被3整除,那x在该位上肯定是1.
 */
public class AppearThreeExceptOnlyOnce {
    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 5, 6, 4, 8, 8, 4, 5,}; // => 6 only appear once
        AppearThreeExceptOnlyOnce ateoo = new AppearThreeExceptOnlyOnce();
        ateoo.solve(nums);
    }

    /**
     * @param nums
     */
    public void solve(int[] nums) {
        //check parameters...

        //开辟int[32]数组, 空间复杂度:1
        int[] ruler = new int[32];

        /**
         *  我的实现思路: 遍历每个数,若某位是1,就将对应ruler位加1., 难点在于判断好每个数不容易.
         *
         *  思路2: 遍历ruler的每个位, 针对每个数的这个位进行判断, 累加. 其实这两个方法的时间复杂度都是O(n), 虽然是两层循环!
         */
        for (int i = 0; i < 32; ++i) {
            for (int j = 0; j < nums.length; ++j) {
                //判断第j个数的第i位是0还是1
                ruler[i] += (nums[j] & 1);

                //右移暴露最右位让 1 去 &
                nums[j] >>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            //根据上面思路, 说明x这位是1
            res += ((ruler[i] % 3) != 0) ? (1 << i) : 0;
        }
        System.out.println(res);
    }

}
