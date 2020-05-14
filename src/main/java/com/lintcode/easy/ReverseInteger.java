package com.lintcode.easy;

/**
 37. 反转一个3位整数
中文English
反转一个只有3位数的整数。

样例
样例 1:

输入: number = 123
输出: 321
样例 2:

输入: number = 900
输出: 9
注意事项
你可以假设输入一定是一个只有三位数的整数，这个整数大于等于100，小于1000。
 * @Author zhouwenchen
 * @Date 20200511
 **/
public class ReverseInteger {

    public static int reverseInteger(int number) {
        StringBuffer sb = new StringBuffer();
        sb.append(number);
        StringBuffer reverse = sb.reverse();
        return Integer.parseInt(reverse.toString());
    }

    public static int reverseInteger1(int number) {
        int a = number / 100;
        int b = (number / 10)% 10;
        int c = number % 10;

        return c*100+b*10+a;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger1(789));
        System.out.println(reverseInteger1(900));
    }
}
