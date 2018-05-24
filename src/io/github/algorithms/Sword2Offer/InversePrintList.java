package io.github.algorithms.Sword2Offer;

import io.github.algorithms.ds.ListNode;

import java.util.ArrayList;

/**
 * Created by zsx at 18-4-22
 *
 * 从尾到头打印链表
 */
public class InversePrintList {
    //还是要训练递归理解问题的方式
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        InversePrintList o = new InversePrintList();
        o.printListFromTailToHead(l1);
        System.out.println(o.list.toString());
    }

}
