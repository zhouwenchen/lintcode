package com.lintcode.easy;

/**
 * 1. A + B 问题
 * 中文English
 * 给出两个整数 aa 和 bb , 求他们的和。
 *
 * 样例
 * 样例 1:
 *
 * 输入:  a = 1, b = 2
 * 输出: 3
 * 样例解释: 返回a+b的结果.
 * 样例 2:
 *
 * 输入:  a = -1, b = 1
 * 输出: 0
 * 样例解释: 返回a+b的结果.
 * 挑战
 * 显然你可以直接 return a + b，但是你是否可以挑战一下不这样做？（不使用++等算数运算符）
 *
 * 说明
 * a和b都是 32位 整数么？
 *
 * 是的
 * 我可以使用位运算符么？
 *
 * 当然可以
 * 注意事项
 * There is no need to read data from standard input stream. Both parameters are given in function aplusb, your job is to calculate the sum and return it.
 * Students in the basic class of the algorithm only need to use the arithmetic operator ‘+’ to complete the problem, without considering the requirements of the bit operation.
 */
public class Aplusb {

    public static int aplusb(int a, int b) {
        if(b == 0){
            return a;
        }

        int sum = a ^ b;
        int carry = (a&b) << 1;
        return aplusb(sum,carry);
    }

    public static void main(String[] args) {
        int sum = aplusb(-1, 3);
        System.out.println(sum);
    }
}
