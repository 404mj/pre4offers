package io.github.algorithms.ds;

import io.github.algorithms.Sword2Offer.Sort;

/**
 * Created by zsx at 18-4-26
 *
 * 链表节点
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val  = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {}

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    /**
     * 返回一个简单的无序单链表
     *@return 5--3--1--9--7--2--6
     */
    public static ListNode getSimpleLinkedList() {
        ListNode head = new ListNode(5);
        ListNode second = new ListNode(3);
        head.setNext(second);
        second.setNext(new ListNode(1));


        second.next.setNext(new ListNode(9));

        ListNode nnn = new ListNode(7);
        ListNode mm = new ListNode(2);
        ListNode mmnn  = new ListNode(6, null);
        second.next.next.setNext(nnn);

        nnn.setNext(mm);
        mm.setNext(mmnn);

        return head;
    }

    /**
     * 返回一个有序的单链表
     * @return
     */
    public static ListNode getSimpleOrderLinkedList() {
        ListNode head = getSimpleLinkedList();
        return Sort.mergeSortLinkedList(head);
    }

    public static void main(String[] args) {
        ListNode a = getSimpleOrderLinkedList();
        while (null != a) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}