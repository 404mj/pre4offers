package com.github;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zsx at 18-4-9
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        //Hashtable<String, Integer> hashtable;
        //ThreadPoolExecutor
        t.testSplit();


    }

    public void testSplit() {
        String s = "20170101";
        String ss = "2017-01-01";
        String[] a = s.split("-");

//        List<String> aa = new ArrayList<>();
//        for (String e : a) {
//            aa.add(e);
//        }
//        System.out.println(aa.get(2));

//        String aa = a[2];
//        System.out.println(aa);
        Charset charset = Charset.forName("gbk");
        ByteBuffer bf = charset.encode(ss);
        bf.toString();

    }

    public void testMultiPara() {
        int[] nums = new int[] {1,2,3,4};
        int[] n1 = {2,3,4,5};
//        multiPara(nums);
//        multiPara(2,3,4,5);
        multiPara(new int[] {1,2,3,4});
    }

    public static void multiPara(int ... params) {
        for (int e: params) {
            System.out.println(e);
        }
    }

    //头条面试的一道题目
    public void toutiaoDummy() {
        int max = Integer.MIN_VALUE;

        //fuck!
        short s = 1;
        s = (short) (s + 1);
        s += 1;
        s++;

    }

    public void viewSource() {
        HashMap<String, Integer> maps = new HashMap<>();
        Map<String, Integer> cmap = new ConcurrentHashMap<>();
        Map<String, Integer> m = Collections.synchronizedMap(maps);
//        Arrays.copyOf();
//        Arrays.copyOf();
//        LinkedHashMap;
//        TreeMap;
//        maps.put();
//        for (Map.Entry e : maps.entrySet()) {}
        List<String> list = new ArrayList<>();
        List<String> ll = list.subList(0, list.size());

        ThreadLocal a = null;
        String.valueOf(23);
//        LinkedList<String> list = new LinkedList<>();
        String s = "sdfd";
        s.length();

    }

    public void testReplace() {
        String s = "my.test.txt";
        System.out.println(s.replace(".", "#"));

        System.out.println(s.replaceAll(".", "#"));
        System.out.println(s.replaceAll("\\.", "#"));

        System.out.println(s.replaceFirst(".", "#"));
        System.out.println(s.replaceFirst("\\.", "#"));

    }

    public void testString() {
        //String类的理解，两种声明方式，栈， 堆， 常量池
        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
        System.out.println(a.equals(b));
        b = b + "xyz";
        System.out.println(a);

        System.exit(1);

        String c = new String("abc");
        String d = new String("abc");
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
    }

    public void testDateJdk8() {
        LocalDate ld = LocalDate.now();
//        System.out.println(ld);

//        LocalDate d1 = LocalDate.of(2018,4,10);
//        System.out.println(d1.getDayOfMonth());

        LocalTime lt = LocalTime.now();
        LocalTime lt1 = lt.plusHours(2);
//        System.out.println(lt1);

        String strDate4 = ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));   // 2017-01-05

        System.out.println(strDate4);
    }

    public void testMulPara(String... args) {
        System.out.println(args[0]);
    }

}
