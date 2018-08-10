package com.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-5-18 下午10:30
 *
 * 数组中有只出现一次的数字, 其他都出现两次.
 * 方案::
 * 1. hashmap
 * 2. 先排序, 然后以2的步长遍历,如果nums[i] != nums[i+1]
 * 3. 位运算:
 * a & a = a, a | a = a,
 * a ^ a = 0, 0 ^ a = a,
 * a^b^c = a^(b^c)
 * ==> 所以说如果只有 **一个出现一次**, 其他只出现***两次*, 挨个异或就可以了!!
 *
 */
public class AppearOnlyOnceNumber {

}
