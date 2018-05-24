package io.github.basic;

/**
 * Created by zsx at 2018-03-31
 */

import java.util.*;

//部分没有使用过的数据类型
public class DataType {

    public static void main(String[] args) {
        DataType  dt = new DataType();
//        dt.demoBitSet();
//        dt.demoVector();
//        dt.demoHashtable();
          dt.demoProperties();

    }


    /**
     * BitSet
     */
    public void demoBitSet() {
        BitSet bs1 = new BitSet(16);
        BitSet bs2 = new BitSet(16);

        for (int i = 0; i < 16; i++) {
            if (i%2 == 0) {
                bs1.set(i);
            }
            if (i%5 == 0) {
                bs2.set(i);
            }
        }

        System.out.println(bs2);
    }

    /**
     * Vector，同步
     */
    public void demoVector() {
        Vector<Integer> v = new Vector<Integer>(10);
        System.out.println("vector 大小：" + v.capacity());

        v.add(23);

        v.addElement(new Integer(12));

        //使用Enumration接口！！
        Enumeration<Integer> veum = v.elements();

        while (veum.hasMoreElements()) {
            System.out.println(" " + veum.nextElement());
        }
    }

    /**
     * Stack栈是vectior的子类
     */
    public void demoStack() {
        //peek,push.pop.search方法
        Stack<String> st = new Stack<String>();
        //....
    }


    /**
     *Hashtable是Dictionary的具体实现， Dictionary原先hashMap的早版本，
     * 和Vector一样是同步的！
     */
    public void demoHashtable() {
        Hashtable ht = new Hashtable(10);
        ht.put("z1", 12);
        ht.put("z2", 23);
        ht.put("sd", 455);
        System.out.println(ht.toString());
    }

    /**
     * Properties类继承Hashtable，
     */
    public void demoProperties() {
        Properties capitals = new Properties();
        Set states;
        String str;

        capitals.put("Illinois", "Springfield");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");

        // Show all states and capitals in hashtable.
        states = capitals.keySet(); // get set-view of keys
        Iterator itr = states.iterator();
        while(itr.hasNext()) {
            str = (String) itr.next();
            System.out.println("The capital of " +
                    str + " is " + capitals.getProperty(str) + ".");
        }
        System.out.println();

        // look for state not in list -- specify default
        str = capitals.getProperty("Florida", "Not Found");
        System.out.println("The capital of Florida is "
                + str + ".");
    }

}
