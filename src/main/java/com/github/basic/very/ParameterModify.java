package com.github.basic.very;

/**
 * Author: fengchen.zsx
 * date: 2018/9/2 10:24
 * <p>
 * Java 参数传递的修改？这么基础的点，我竟然有点迷糊
 * <p>
 * 默认以为传递基本类型就是值传递，引用类型就是引用传递！其实是这样在java中可以归结为统一的值传递，基本类型就是值，引用类型就是引用的值！！
 * <p>
 * ，有两个问题：：
 * 1、数组类型，集合类型，自定义对象 都算是引用类型！！！
 * 2、因为java中包装类的存在，String，Integer等，传递的是引用不假，但是传递的引用的复制！！，但是在重新赋值过程中会新建一份值！并不会影响大原来的值
 * <p>
 * ---
 * ref：https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
 */
public class ParameterModify {
    public static void main(String[] args) {
        ParameterModify pm = new ParameterModify();
        int oa = 1;
        int[] oas = {1, 2, 3};
        Integer oi = 2;
        Integer[] ois = {78, 790, 650};
        String s = "zzzz";
        String[] ss = {"zzz", "xxx", "yyy"};

        Person p = new Person("zhangSan");

        pm.modifyObject(s);
        System.out.println(s);
    }

    public void modifyPrimitive(int a) {
        a = a + 1; // 不变
    }

    public void modifyPrimitive(int[] nums) {
        nums[1] = 1111; // 变了
    }

    public void modifyObject(Integer oi) {
        oi = 44444; // 不变
    }

    public void modifyObject(Integer[] ois) {
        ois[1] = 44444; // 变了
    }

    public void modifyObject(String os) {
        System.out.println("in func: " + os);
        os = "44444"; // 不变
        System.out.println("in func: " + os);
    }

    public void modifyObject(String[] oss) {
        oss[1] = "44444"; // 变了
    }

    public void modifyObject(Person person) {
        person.setName("lisi");
    }


    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
