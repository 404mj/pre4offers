package com.github.basic;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Joseph
 * @version 1.0
 * @DATE 2018-4-9
 */
public class Table<T> {

    List<List<T>> table;
    private String tableName;
    private String filePath;

    public Table(Class<T> t) {
        table = new ArrayList<List<T>>();
    }

    public int rows() {
        return table.size();
    }

    public int cols() {
        if (rows() == 0) {
            return 0;
        } else {
            return table.get(0).size();
        }
    }

    public T get(int i, int j) {
        if (i < 0 || i > rows() - 1 || j < 0 || j > cols() - 1) {
            throw new IndexOutOfBoundsException();
        }

        return table.get(i).get(j);
    }

    public List<T> getRow(int i) {
        if (i < 0 || i > rows() - 1) {
            throw new IndexOutOfBoundsException();
        }
        return table.get(i);
    }

    public T set(int i, int j, T x) {
        if (i < 0 || i > rows() - 1 || j < 0 || j > cols() - 1) {
            throw new IndexOutOfBoundsException();
        }

        return table.get(i).set(j, x);
    }

    public void addRow(int i) {
        if (i < 0 || i > rows()) {
            throw new IndexOutOfBoundsException();
        }

        table.add(i, new ArrayList<T>());

        for (int j = 0; j < cols(); j++) {
            table.get(i).add(null);
        }
    }

    public void addRow(int i, List<T> list) {
        if (i < 0 || i > rows()) {
            throw new IndexOutOfBoundsException();
        }
        table.add(i, list);
    }

    public void addCol(int j) {
        if (j < 0 || j > cols()) {
            throw new IndexOutOfBoundsException();
        }

        if (rows() == 0) {
            addRow(0);
        }

        for (int i = 0; i < rows(); i++) {
            table.get(i).add(j, null);
        }
    }


    public void removeRow(int i) {
        if (i < 0 || i > rows() - 1) {
            throw new IndexOutOfBoundsException();
        }

        table.remove(i);
    }

    public void removeCol(int j) {
        if (j < 0 || j > cols() - 1) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < rows(); i++) {
            table.get(i).remove(j);
        }
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        String str = "";
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++) {
                str = (j == (cols() - 1)) ? (table.get(i).get(j) + "") : (table.get(i).get(j) + ",");
                sb.append(str);
            }
            sb.append("\n");
        }
        return "Table{" +
                "tableName=" + tableName + "\n" + sb.toString() +
                '}';
    }

    public static void main(String[] args) {
        Table<Integer> table = new Table<Integer>(Integer.class);
        for (int i = 0; i < 4; i++) {
            table.addCol(table.cols());
        }
        for (int i = 0; i < 4; i++) {
            table.addRow(table.rows());
        }
        System.out.println(table.toString());
        System.out.println("rows: " + table.rows() + "\ncols: " + table.cols());

        for (int i =0; i<2; i++) {
            table.removeCol(i);
        }
        System.out.println("QQQ"+table);
        table.removeRow(1);

        System.out.println("rows: " + table.rows() + "\ncols: " + table.cols());
        System.out.println(table.toString());

        int[] arr = new int[]{1, 2, 3, 4, 5};


    }
}
