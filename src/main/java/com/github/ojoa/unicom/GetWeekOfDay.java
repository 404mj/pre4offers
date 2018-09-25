package com.github.ojoa.unicom;

/**
 * Created by fengchen.zsx
 * Date: 18-9-25 下午9:34
 * <p>
 * 计算一个日期是周几。
 * https://www.jianshu.com/p/9396de24c88f
 * 使用Calendar或者使用SimpleDateFormat.format("EEEE")
 * 对于创建SimpleDateFormat传入的参数：EEEE代表星期，如“星期四”；MMMM代表中文月份，如“十一月”；MM代表月份，如“11”；
 * yyyy代表年份，如“2010”；dd代表天，如“25”
 */

import java.text.SimpleDateFormat;
import java.util.*;

public class GetWeekOfDay {

    private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> tst = new ArrayList<String>();

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.length() == 0) break;
            tst.add(s);
        }

        for (String s : tst) {
            if (check(s)) {
                System.out.println(getWeek(s));
            } else {
                System.out.println("illegal");
                break;
            }
        }
        sc.close();

    }

    private static boolean check(String in) {

        if (in == null || in.length() == 0) {
            return false;
        }

        try {
            fmt.setLenient(false);
            Date d = fmt.parse(in);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private static String getWeek(String dateStr) {
        int week;
        Calendar cal = Calendar.getInstance();

        try {
            Date d = fmt.parse(dateStr);
            cal.setTime(d);
        } catch (Exception e) {
            return null;
        }


        week = cal.get(Calendar.DAY_OF_WEEK);

        switch (week) {
            case 1: {
                return "Sunday";
            }
            case 2: {
                return "Monday";
            }
            case 3: {
                return "Tuesday";
            }
            case 4: {
                return "Wednesday";
            }
            case 5: {
                return "Thursday";
            }
            case 6: {
                return "Friday";
            }
            case 7: {
                return "Saturday";
            }
            default:
                break;
        }
        return null;
    }
}