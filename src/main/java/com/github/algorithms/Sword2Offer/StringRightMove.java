package com.github.algorithms.Sword2Offer;

/**
 * Author: 奉晨
 * date: 2018/6/3 16:16
 * <p>
 * 字符串过滤函数，输入一个字符串包含字母数字特殊字符，
 * 只保留消息字母
 * 并将小写字母的循环右移m位（a->3==d）
 * example: input: diWfg123D => glij
 */
public class StringRightMove {
    public static void main(String[] args) {
        StringRightMove srm = new StringRightMove();
        String s = "diWfg123D";
//        System.out.println('a'==97);
//        System.out.println((char)97);
        srm.mysolve(s, 3);

    }

    /**
     * 过滤大小写：
     * 1. >='a' <= 'z'
     * 2. >='97' <= '122' || 65 - 90
     * 3. Character.isUpperCase()
     * <p>
     * 循环右移类似循环链表的取下标操作，没啥难度
     * 实现方式很多：1. 用原始的97-122，对123取余。
     * 2. 将97-122的26个字符映射到0-25的字符数组上。
     * 3. 取与a的差和25取余，再加上a即可。
     *
     * @param str
     */
    public void mysolve(String str, int m) {
        //check parameters...

        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                //右移
                int nc = (c + m) % 123;
                ret.append(nc >= 97 ? (char) nc : (char) ('a' + nc));
            }
        }
        System.out.println("res--> " + ret.toString());
    }

}
