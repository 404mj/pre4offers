package io.github.algorithms.Sword2Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: 奉晨
 * date: 2018/6/3 17:17
 * <p>
 * 电梯的停止次数，大楼M层>=2, 只要一个电梯，最大承重位k,
 * n个排队上电梯的人，体重为w[1--n-1],目的楼层d[1---n-1]，求电梯运完这些人需要停多少次。
 * <p>
 * example: w=[80,90];d[3,3];m=4; k=100;
 * 所以需要先运行w1到3层，再下来运w2到三层，一共是两次。如果k=180，那就只用停止一次
 */
public class ElevatorStopTimes {
    public static void main(String[] args) {
        ElevatorStopTimes est = new ElevatorStopTimes();
        int[] w = {5, 10, 8, 7, 4, 2, 7, 1};
        int[] d = {3, 4, 3, 2, 5, 6, 5, 6};
        int m = 10;
        int k = 20;

        est.mysovle(w, d, m, k);

    }

    /**
     * 分析: 因为排队，肯定是顺序上，对于 **每一次的乘坐**，停止次数是电梯内人目的地种类数（总数-相同数）
     * <p>
     * 要用到去重的方法，总结：
     * 1. 最直接的两层遍历
     * 2. 使用list.contains()方法，对数组每一个元素不存在就add
     * 3. 使用set，把数组元素add一遍就可以了
     * 4. 排序， 相邻的相等的就是重复的！
     * 5. 。。。
     * <p>
     * 剩下的问题就是每一次的乘坐时按照体重划分。
     * <p>
     * 我的想法是对的，先划分，划分好了之后计算每一组内的个数。
     * 但是代码实现想复杂了，可以一次就处理好。 实际版本参考了：
     * https://blog.csdn.net/yuxin6866/article/details/52878437
     * 想法和实现上有差距，我思考原因是：太受工程项目化的影响，死板，不灵活。可以适当的
     * 以最小化去思考问题。切分的时候如果可以在一次遍历的时候操作完成就更好了。不需要再记录中间过程只完成最后的任务即可。
     *
     * @param w 排队人体重数组
     * @param d 目的地数组
     * @param m 最大楼层
     * @param k 最大承重
     */
    public void mysovle(int[] w, int[] d, int m, int k) {
        //check parameters...

        int sumw = 0;
        int count = 0;
        Set<Integer> partation = new HashSet<>();
        for (int i = 0; i < w.length; ++i) {
            sumw += w[i];

            if (sumw <= k) {
                partation.add(d[i]);
            } else {
                count += partation.size();
                partation.clear();
                sumw = 0;
                i--;
            }
        }
        //处理最后的残余
        count += partation.size();
        System.out.println("res-> " + count);
    }
}
