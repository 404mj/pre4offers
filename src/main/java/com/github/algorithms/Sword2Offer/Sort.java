package com.github.algorithms.Sword2Offer;

import com.github.algorithms.ds.ListNode;

import java.util.Arrays;

public class Sort {
    /**
     * --------------快速排序----------------
     *
     * @param input
     */
    int i, j, temp;

    public static void main(String[] args) {
//        int[] input = {10, 35, 2, 12, 5, 9, 21, 40, 74, 8};
//        int[] input = {5, 1, 6, 7, 9, 3};
//        int[] input = {1, 2, 1, 5, 0, 2, 7, 4};
        int[] input = {4, 11, 17, 231, 56, 9, 43};

        //使用排序方法
        Sort s = new Sort();
//        s.mergeSort(input, 0, input.length -1);
//        s.heapSort(input);
//        s.bubbleSort(input);
//        s.selectionSort(input);
//        s.quickSort(input, 0, input.length - 1);
//        for (int i : input) {
//            System.out.print(i + "   ");
//        }
//        s.countingSort(input);
        s.radixSort(input);
        System.out.println();
    }

    //进行归并排序
    public static void merge(int[] input, int start, int middle, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = middle + 1, n = 0;

        while (i <= middle && j <= end) {
            if (input[i] < input[j]) {
                tmp[n++] = input[i++];
            } else {
                tmp[n++] = input[j++];
            }
        }
        //处理剩下的两边输入长度不一样
        while (i <= middle) {
            tmp[n++] = input[i++];
        }
        while (j <= end) {
            tmp[n++] = input[j++];
        }
        for (int x = 0, y = start; x <= n && y <= end; x++, y++) input[y] = tmp[x];
    }

    // 调整的本质是对i节点和他的左右孩子进行比较，依次向下进行比较
    public static void heapSift(int[] input, int i, int n) {
        int child;
        for (; i <= n / 2; ) {
            child = i * 2;//做孩子
            //比较孩子中哪个大
            if ((child + 1) <= n && input[child] < input[child + 1]) {
                child += 1;
            }
            //i节点比孩子小
            if (input[i] < input[child]) {
                int tmp = input[i];
                input[i] = input[child];
                input[child] = tmp;
                i = child; // 一次向下
            } else
                break;
        }
    }

    /**
     * 对单链表排序, 归并算法
     * ListNode => val是int类型
     *
     * @param head
     * @return
     */
    public static ListNode mergeSortLinkedList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode middle = getMiddleNode(head);
        ListNode middleR = middle.next;
        middle.next = null;//切断连接

        ListNode tmp1 = mergeSortLinkedList(head);
        ListNode tmp2 = mergeSortLinkedList(middleR);

        return merge(tmp1, tmp2);
    }

    private static ListNode merge(ListNode oneList, ListNode twoList) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        /**
         *上面这个地方bug排查了好久!!!,傻逼了, 只声明了cur, 最后返回cur.next, 只有一个元素了!
         * 逻辑问题
         * 排查问题思路不行了也
         * 刷算法必须!!!
         */

        while (oneList != null && twoList != null) {
            if (oneList.val <= twoList.val) {
                cur.next = oneList;
                oneList = oneList.next;
            } else {
                cur.next = twoList;
                twoList = twoList.next;
            }
            cur = cur.next; //重要!
        }
        cur.next = (oneList == null) ? twoList : oneList;
        return dummyHead.next;
    }

    private static ListNode getMiddleNode(ListNode head) {
        ListNode oneStep = head, twoStep = head;
        while (twoStep.next != null && twoStep.next.next != null) {
            //注意这里的条件, 先判断next防止NullPointerException
            twoStep = twoStep.next.next;
            oneStep = oneStep.next;
        }
        return oneStep;
    }

    /**
     * -------------归并排序----------------
     *
     * @param input
     * @param start
     * @param end
     */
    public void mergeSort(int[] input, int start, int end) {
        int mid;
        // 递归分割输入
        if (start < end) {
            mid = (start + end) / 2;
            mergeSort(input, start, mid);
            mergeSort(input, mid + 1, end);
            merge(input, start, mid, end);
        }
    }

    /**
     * ---------堆排序----------
     *
     * @param input
     */
    public void heapSort(int[] input) {
        //堆其实就是完全二叉树-建堆，--调整
        //自下而上调整
        for (int i = input.length / 2; i >= 0; i--) {
            heapSift(input, i, input.length - 1);
        }
        //堆只能保证首元素的最大，因此把首元素和最后一个交换，重新
        //调整，
        for (int i = input.length - 1; i >= 0; i--) {
            int tmp = input[0];
            System.out.println(tmp);
            input[0] = input[i];
            input[i] = tmp;
            heapSift(input, 0, i - 1);
        }
    }

    /**
     * ---------冒泡排序---------
     *
     * @param input
     */
    public void bubbleSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - 1; j++) {
                if (input[j] > input[j + 1]) { // 下标写法有很多！
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
    }

    /**
     * ---------选择排序---------
     *
     * @param input
     */
    public void selectionSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            for (int j = i; j < input.length - 1; j++) {
                if (input[minIndex] > input[j + 1])
                    minIndex = j + 1;
            }
            if (minIndex != i) {
                int temp = input[i];
                input[i] = input[minIndex];
                input[minIndex] = temp;
            }
        }
    }

    /**
     * --------------插入排序----------------
     *
     * @param input
     */
    public void insertionSort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    int temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                } else break;
            }
        }
    }


    /**
     * ---------------------快速排序-------------------
     *
     * @param input
     * @param start
     * @param end
     */
    public void quickSort(int[] input, int start, int end) {
        if (start < end) {
            i = start;
            j = end;
            temp = input[start];
            while (i < j) {
                while (i < j && input[j] >= temp)
                    j--;
                while (i < j && input[i] <= temp)
                    i++;
                int exchange = input[j];
                input[j] = input[i];
                input[i] = exchange;
            }
            //把temp放到正确位置上
            input[start] = input[j];
            input[j] = temp;
            quickSort(input, start, j - 1);
            quickSort(input, j + 1, end);
        }
    }


    /**
     * ------------------------基数排序-------------------------
     * reference: https://www.cnblogs.com/developerY/p/3172379.html (思路)
     * https://www.geeksforgeeks.org/radix-sort/
     * MSD(most significant digital)
     * LSD(least significant digital)
     * <p>
     * <p>
     * 待排序的数组R[1..n],数组中最大的数是d位数，基数为r（如基数为10，即10进制，
     * 最大有10种可能，即最多需要10个桶来映射数组元素）
     * 时间复杂度O(d*(n+r))
     * 空间复杂度O(d*r)
     * <p>
     * ref: https://www.thecrazyprogrammer.com/2015/06/radix-sort-java-program-and-algorithm.html
     *
     * @param nums
     */
    public void radixSort(int[] nums) {
        //check parameters....

        int i, m = nums[0], n = nums.length;
        int exp = 1;//每一位的权值!1, 10, 100, 1000,...
        int[] tenBits = new int[10];//十进制

        //get max of nums
        for (i = 1; i < n; i++) {
            if (nums[i] > m)
                m = nums[i];
        }

        /**
         * 步骤2,3 是计数排序的套路, 不使用二维数组记录,改为用一个一维数组每次都
         * 更新一维数组来减少空间复杂度!
         *
         * * * bucket数组计数!
         * * * tenBits数组记录值!
         *
         *从个位开始比较::

         */
        while (m / exp > 0) {
            int[] bucket = new int[10];

            //1.-----
            for (i = 0; i < n; i++)
                bucket[(nums[i] / exp) % 10]++;//从低位到高位取数字!

            //2.-----
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];

            //3.-----
            for (i = n - 1; i >= 0; i--)
                tenBits[--bucket[(nums[i] / exp) % 10]] = nums[i];

            //4.-----更新数组
            for (i = 0; i < n; i++)
                nums[i] = tenBits[i];

            exp *= 10;
        }

        Arrays.stream(nums).forEach(System.out::println);
    }


    /**
     * ------------------计数排序(桶排序)-------------------------
     * reference:  https://www.geeksforgeeks.org/counting-sort/
     *
     * @param nums
     */
    public void countingSort(int[] nums) {
        //check parameters...

        //确定数组大小
        int m = nums[0];
        for (int e : nums) {
            m = Math.max(e, m);
        }

        //收集每个数字出现次数
        int[] counter = new int[m + 1];//假设数组有0存在
        for (int e : nums) {
            ++counter[e];
        }
        /**
         * 统计出来之后有两种方案/操作方式,
         * 1. 直接的: 从头到尾遍历counter,>0的情况下, 有几个就输出几个,或者放到结果数组
         *
         * 2. 间接的: 从头到尾遍历countger, 每个元素对应的值都累积了之前所有的(其实就是每个元素在最后的排好序的结果中的最大index).
         * 遍历nums每个元素.
         */
        //采用2方式
        for (int i = 1; i < counter.length; ++i) {
            counter[i] += counter[i - 1];
        }

        //根据counter结果设置nums排序
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[counter[nums[i]] - 1] = nums[i];
            --counter[nums[i]];
        }

        Arrays.stream(res).forEach(System.out::println);
    }

    /**
     *   ------------------希尔排序-------------------------
     *
     * @param nums
     */
    public void shellSort(int[] nums) {

    }


}
