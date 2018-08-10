package com.github.basic;

import java.io.UnsupportedEncodingException;

/**
 * Created by zsx at 18-5-2
 */
public class Encoding {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Encoding e = new Encoding();
//        e.test1();
        String cn = "中文";
        System.out.println(e.detectEncoding(cn));

    }

    public void test1() throws UnsupportedEncodingException {
        System.out.println("中文");

        System.out.println("中文".getBytes());

        System.out.println("中文".getBytes("GB2312"));

        System.out.println("中文".getBytes("ISO8859_1"));

        System.out.println(new String("中文".getBytes()));

        System.out.println(new String("中文".getBytes(), "GB2312"));

        System.out.println(new String("中文".getBytes(), "ISO8859_1"));

        System.out.println(new String("中文".getBytes("GB2312")));

        System.out.println(new String("中文".getBytes("GB2312"), "GB2312"));

        System.out.println(new String("中文".getBytes("GB2312"), "ISO8859_1"));

        System.out.println(new String("中文".getBytes("ISO8859_1")));

        System.out.println(new String("中文".getBytes("ISO8859_1"), "GB2312"));

        System.out.println(new String("中文".getBytes("ISO8859_1"), "ISO8859_1"));

        System.out.println(new String("中文".getBytes("UTF-8"), "UTF-8"));
    }

    public String detectEncoding(String source) {
        String[] charsetsToBeTested = {"UTF-8", "windows-1253", "ISO-8859-1", "GB2312", "GBK"};
        for (String coding:charsetsToBeTested) {
            try {
                if (source.equals(new String(source.getBytes(coding),coding))) {
                    return coding;
                }
            }catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
        return charsetsToBeTested[0];
    }

}
