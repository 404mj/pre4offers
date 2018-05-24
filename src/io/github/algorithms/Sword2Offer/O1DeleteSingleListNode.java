package io.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-5-14 下午9:04
 *
 * 在 O(1) 时间内,删除掉单链表内某指针指定的节点!!
 *
 * 解析::采用了一种“狸猫换太子”的方法
 * 因为删除该节点p, 需要知道它的前缀, 在O(1)下做不到!
 *
 * 可以把p做为前缀!,意思就是删除掉p的next节点.
 *
 * 然后让p节点"伪装"成next节点, 这样就相当于删除掉了p节点!!!
 *
 */
public class O1DeleteSingleListNode {

}
