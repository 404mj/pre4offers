package io.github.algorithms.Sword2Offer;

/**
 * Created by zsx at 18-4-22
 */
public class Demo {
    public static void main(String[] args) {
        Demo d = new Demo();
    }


    /**
     * 旋转数组的最小数字
     */
    public int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0) return 0;
        for (int i = 0, j = i + 1; i < len - 1 && j < len; ++i, ++j) {
            if (array[j] < array[i]) {
                return array[j];
            }
        }
        return array[0];
    }

    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }


}
