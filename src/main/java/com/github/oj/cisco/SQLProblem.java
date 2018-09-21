package com.github.oj.cisco;

/**
 * Created by fengchen.zsx
 * Date: 18-9-20 下午10:22
 */
public class SQLProblem {
    /**
     * 思科的一个sql题目：
     * Table A：userId,email
     * Table B: UID, email
     *
     * res? select email from A, B where userId = UID;
     *
     * ERROR 1052 (23000): Column 'email' in field list is ambiguous
     */
}
