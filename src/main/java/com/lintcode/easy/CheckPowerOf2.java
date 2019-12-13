package com.lintcode.easy;

/**
 * 142. O(1)时间检测2的幂次
 * 中文English
 * 用 O(1) 时间检测整数 n 是否是 2 的幂次。
 *
 * 样例
 * Example 1:
 * 	Input: 4
 * 	Output: true
 *
 *
 * Example 2:
 * 	Input:  5
 * 	Output: false
 *
 * 挑战
 * O(1) time
 */
public class CheckPowerOf2 {
    public static void main(String[] args) {
        boolean b = checkPowerOf2(4);
        System.out.println(b);
    }

    public static boolean checkPowerOf2(int n) {
        if( n <= 0){
            return false;
        }
        return (n&(n-1)) == 0;
    }
}
