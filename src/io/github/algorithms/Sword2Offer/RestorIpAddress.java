package io.github.algorithms.Sword2Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsx at 18-4-23
 *
 * 将字符串转换成Ip地址
 * Given "25525511135",
 *  return ["255.255.11.135", "255.255.111.35"]
 *  递归和深度优先真牛逼!
 *
 */
public class RestorIpAddress {
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        String ip = "100101234";
//        String ip = "12312325534";
//        String ip = "25525511135";
        RestorIpAddress r = new RestorIpAddress();
        r.restoreIpAdress(ip);
    }

    public void restoreIpAdress(String s) {
        if (s == null ||s.length() < 4 || s.length() > 12) return;

        dfs(s, "", res, 0);

        System.out.println(res);
    }

    /**
     * 深度有限遍历结果!
     * @param s
     * @param tmp
     * @param res
     * @param count
     */
    public static void dfs(String s, String tmp, List<String> res, int count) {
        if (count == 3 && isValid(s)) {
            res.add(tmp+s);
        }

        for (int i=1; i<4 && i<s.length(); i++) {
            String sub = s.substring(0,i);
            if (isValid(sub)) {
                dfs(s.substring(i), tmp + sub +".", res, count + 1);
            }
        }
    }

    public static boolean isValid(String s) {
//        System.out.println(s);
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        return num > 0 && num <= 255;
    }

    /**
     * 思考过程: 对于没一个string,分为三种情况:取1,取2,取3.进行组合,dfs便是好的.
     * 判断字符是否合格如果是0开头,01||010||03都不对,因为ip中没有这样的往后追加没用.其次才是parseInt
     */

}
