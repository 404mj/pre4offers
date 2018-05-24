package io.github.algorithms.Sword2Offer;

import io.github.algorithms.ds.ListNode;

/**
 * Created by zsx at 18-4-27
 * <p>
 * 数组就地去重复!!
 * <p>
 * 去重系列!!!
 * <p>
 * 设置一个指针k，标记目前不重复的最后一位，从前往后遍历，
 * 如果严格递增，就将该值覆盖k后一位，否则不进行操作，
 */
public class ArrayClearRepeatInPlace {

    /**
     * 移除排好序的数组中的重复元素
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[k]) {
                nums[++k] = nums[i];
            }
        }

        return k + 1;
    }

    /**
     * 移除链表中重复的元素,非递归方案!
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    //递归方案!!
    public ListNode deleteDuplicatesLinkedRecur(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicatesLinkedRecur(head.next);
        return head.val == head.next.val ? head.next : head;
    }

}
