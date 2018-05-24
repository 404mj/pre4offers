package io.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-5-14 下午9:08
 *
 * 寻找两个单链表的公共节点!!!
 * 1. O(n^2) 绝对不采用
 * 2.方案解析:::
 *  如果l1和l2等长, 两个指针i,j同时移动, 当指针执行的Node相同时, 就是公共节点!
 *
 *  如果l1和l2不等长, 想象Y形状! 长度差值为sub, 让长的先走sub, 然后i,j再同时移动,
 *  当执向的两个Node相同时候, 就是公共节点!
 *
 *
 */
public class FindTwoLinkedListCommonNode {

}
