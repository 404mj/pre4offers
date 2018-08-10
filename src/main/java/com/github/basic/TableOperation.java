package com.github.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsx at 18-4-24
 */
public class TableOperation {

    public Table<String> SplitSeparator(Table<String> table, int col, String seprator, List<String> titles) {
        //校验参数
        if (table == null || seprator == null || col < 0 || col > (table.cols() - 1) ) {
            throw new IndexOutOfBoundsException();
        }
        if (titles == null || titles.size() != table.get(0,col-1).split(seprator).length) {
            throw new UnsupportedOperationException();
        }


        //处理数据,暂时没考虑标题, i的初始值?
        for (int i=0; i<table.rows(); ++i) {
            //每个List<String>对象 对应每一行
            List<String> listEle = table.getRow(i);
            Integer cursor = col-1;
            String[] seqs = listEle.get(col-1).split(seprator);
            //设置分割后的对应列值
            for (String str : seqs) {
                if (cursor == col-1) {
                    //原列set
                    listEle.set(cursor++, str);
                }else {
                    //后面的add,顺位后移
                    listEle.add(cursor++, str);
                }
            }

        }

        return null;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        list.add(3,"f");
        System.out.println(list);
        list.set(2, "u");
        System.out.println(list);
        int cursor = 1;
        list.set(cursor++,"p");
        System.out.println(list);
        System.out.println(cursor);
    }
}
