package com.lintcode.easy;
/*
计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。

您在真实的面试中是否遇到过这个题？
样例
样例 1：

输入：
k = 1, n = 1
输出：
1
解释：
在 [0, 1] 中，我们发现 1 出现了 1 次 (1)。
样例 2：

输入：
k = 1, n = 12
输出：
5
解释：
在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] 中，我们发现 1 出现了 5 次 (1, 10, 11, 12)(注意11中有两个1)
 * @Author zhouwenchen
 * @Date 20200506
 **/

import java.util.HashMap;
import java.util.Map;

public class DigitCounts {

    public static int digitCounts(int k, int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(k, 0);
        char nstr = String.valueOf(k).toCharArray()[0];
        for (int i = 0; i <= n; i++) {
            String value = String.valueOf(i);
            char[] charArr = value.toCharArray();
            for (char c : charArr) {
                if (nstr == c) {
                    map.put(k, map.get(k)+1);
                }
            }
        }
        return map.get(k);
    }

    /**
     * 使用除法 和 取余 实现
     * @param k
     * @param n
     * @return
     */
    public static int digitCounts2(int k, int n) {
        int count= k == 0 ? 1 : 0;
        for (int i = 0; i <= n; i++) {
            if(i < k){
                continue;
            }
            int temp = i;
            while (temp > 0){
                if(temp % 10 == k){
                    count++;
                }
                temp /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int counts = digitCounts2(1, 12);
        System.out.println(counts);
    }
}
