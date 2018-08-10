package com.github.algorithms.ds;

/**
 * Created by zsx at 18-4-23
 *
 * 默认二叉树节点
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * 返回没有头节点的随机二叉树
     * @return
     */
    public static TreeNode getSimpleTreeNoHead() {
        TreeNode first = new TreeNode(5);
        first.setLeft(new TreeNode(6));
        first.setRight(new TreeNode(9));

        TreeNode th = new TreeNode(3);
        TreeNode th1 = new TreeNode(2);
        th1.setRight(new TreeNode(11));
        th1.setLeft(new TreeNode(4));

        first.left.left = th;
        first.left.right = th1;

        first.right.left = new TreeNode(1);
        first.right.right = new TreeNode(7);

        return first;
    }

    /**
     * 返回二叉排序树
     * 4  6  8  10  12  14  16
     * @return
     */
    public static TreeNode getBSTree() {
        TreeNode root = new TreeNode(10);
        TreeNode six = new TreeNode(6);
        TreeNode forteen = new TreeNode(14);

        six.setLeft(new TreeNode(4,null, null));
        six.setRight(new TreeNode(8, null, null));
        forteen.setLeft(new TreeNode(12, null, null));
        forteen.setRight(new TreeNode(16, null, null));

        root.setLeft(six);
        root.setRight(forteen);

        return root;
    }

}
