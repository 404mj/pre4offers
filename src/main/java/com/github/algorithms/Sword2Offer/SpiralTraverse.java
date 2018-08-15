package com.github.algorithms.Sword2Offer;

import com.github.algorithms.ds.TreeNode;

import java.util.Stack;

/**
 * Created by zsx at 18-4-23
 * <p>
 * S形遍历二叉树 || zigzag形遍历 || 之字形遍历！
 * 使用两个栈实现
 */
public class SpiralTraverse {

    public static void spiralOrderVisit(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        if (root != null) {
            stack1.push(root);
        }

        TreeNode tmp = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            //先从右往左
            while (!stack1.isEmpty()) {
                tmp = stack1.pop();
                System.out.println(tmp.val);

                if (tmp.right != null)
                    stack2.push(tmp.right);
                if (tmp.left != null)
                    stack2.push(tmp.left);
            }

            //从左往右
            while (!stack2.isEmpty()) {
                tmp = stack2.pop();
                System.out.println(tmp.val);

                if (tmp.left != null)
                    stack1.push(tmp.left);
                if (tmp.right != null)
                    stack1.push(tmp.right);
            }

        }

    }

    public static void main(String[] args) {
        TreeNode demoTree = TreeNode.getSimpleTreeNoHead();
        spiralOrderVisit(demoTree);
    }
}
