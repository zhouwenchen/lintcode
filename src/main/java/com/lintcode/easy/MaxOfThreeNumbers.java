package com.lintcode.easy;

/**
 * 283. 三数之中的最大值
 * 中文English
 * 给三个整数，求他们中的最大值。
 *
 * 样例
 * 样例  1:
 * 	输入:  num1 = 1, num2 = 9, num3 = 0
 * 	输出: 9
 *
 * 	样例解释:
 * 	返回三个数中最大的数。
 *
 * 样例 2:
 * 	输入:  num1 = 1, num2 = 2, num3 = 3
 * 	输出: 3
 *
 * 	样例解释:
 * 	返回三个中最大的数字。
 */
public class MaxOfThreeNumbers {
    public static void main(String[] args) {
        int maxValue = maxOfThreeNumbers(1, 2, 3);
        System.out.println(maxValue);
    }

    public static int maxOfThreeNumbers(int num1, int num2, int num3) {
       return Math.max(num1,Math.max(num2,num3));
    }
}
