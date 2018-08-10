package com.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-4-22
 *
 * 二维有序数组查找
 *
 */
public class ArrayFind {
    public boolean Find(int target, int[][] array) {
//        从左下角开始找
        int i = array.length-1;
        int j = 0;
        while (i>=0 && j<array[0].length) {
            if (target == array[i][j]) {
                return true;
            }else if (target < array[i][j]) {
                i--;
            }else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,3,6,7}, {2,4,7,8}, {5,7,9,12}};
    }
}
