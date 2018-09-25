package com.github.ojoa.zhihu;

/**
 * Created by fengchen.zsx
 * at 18-9-17 上午9:07
 */
public class DuplicatedBinarySearch {

    public static void main(String[] args) {
        int[] tmp = {1, 2, 2, 3, 4, 4, 4, 5, 6, 7, 7};
        int target = 7;
        int result = DuplicatedBinarySearch.search(target, tmp);
        System.out.println(result);
    }

    public static int search(int target, int[] arr) {

        if (arr.length == 0) {
            return -1;
        }
        int left = 0, right = arr.length - 1;

        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (target > arr[mid]) {
                left = mid + 1;
            }
            if (target < arr[mid]) {
                right = mid - 1;
            }
            if (target == arr[mid]) {
                left = mid;
            }
        }

        if (right == arr.length - 1)
            return right;
        if (arr[left] == arr[right] && arr[right + 1] == target) {
            return left + 1;
        }
        if (arr[right] == target) {
            return right;
        }
        if (arr[left] == target) {
            return left;
        }
        return -1;
    }

}
