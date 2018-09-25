package com.github.ojoa.zhihu;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by fengchen.zsx
 * at 18-9-17 上午10:11
 */
public class BracketsMatch {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        Scanner sc = new Scanner(System.in);

        String target = sc.next();
        if (target == null) {
            System.out.println("False");
            return;
        }
        sc.close();

        char[] chars = target.toCharArray();
        int k = 0;

        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
            }else {
                if (c == ')' && !stack.empty() &&stack.peek().toString().equals("(")) {
                    stack.pop();
                }else {
                    stack.push(')');
                }
            }
        }

        boolean isMatch = stack.isEmpty();
        if (isMatch) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}