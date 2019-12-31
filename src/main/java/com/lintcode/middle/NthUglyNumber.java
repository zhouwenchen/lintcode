package com.lintcode.middle;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 4. 丑数 II
 * 中文English
 * 设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
 *
 * 符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 *
 * 样例
 * 样例 1：
 *
 * 输入：9
 * 输出：10
 * 样例 2：
 *
 * 输入：1
 * 输出：1
 * 挑战
 * 要求时间复杂度为 O(nlogn) 或者 O(n)。
 *
 * 注意事项
 * 我们可以认为 1 也是一个丑数。
 */
public class NthUglyNumber {

    public static int nthUglyNumber(int n) {
        Queue<Long> Q = new PriorityQueue<Long>();
        HashSet<Long> inQ = new HashSet<>();

        Long[] params = new Long[]{2L,3L,5L};
        for(int i = 0; i < 3; i++){
            Q.add(params[i]);
            inQ.add(params[i]);
        }
        Long number = Long.valueOf(1);
        for(int i = 1; i < n; i++){
            number = Q.poll();
            for(int j = 0; j < 3;j++){
                if (!inQ.contains(params[j] * number)) {
                    Q.add(number * params[j]);
                    inQ.add(number * params[j]);
                }
            }
        }
        return number.intValue();
    }

    public static void main(String[] args) {
        int num = nthUglyNumber(9);
        System.out.println(num);
    }
}
