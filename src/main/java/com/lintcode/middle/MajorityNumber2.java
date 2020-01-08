package com.lintcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 主元素 II
 * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的三分之一。
 *
 * 样例
 * 例1:
 *
 * 输入: [99,2,99,2,99,3,3],
 * 输出: 99.
 * 例2:
 *
 * 输入: [1, 2, 1, 2, 1, 3, 3],
 * 输出: 1.
 * 挑战
 * 要求时间复杂度为O(n)，空间复杂度为O(1)。
 *
 * 注意事项
 * 数组中只有唯一的主元素
 */
public class MajorityNumber2 {
    public static int majorityNumber(List<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            int newNum = nums.get(i);
            if (count1 == 0) {
                num1 = newNum;
                count1++;
            } else if (num1 == newNum) {
                count1++;
            } else if (count2 == 0) {
                num2 = newNum;
                count2++;
            } else if (num2 == newNum) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == num1) {
                count1++;
            }

            if (nums.get(i) == num2) {
                count2++;
            }
        }
        return count1 > count2 ? num1 : num2;
    }

    public static void main(String[] args) {
//        int i = majorityNumber(Arrays.asList(1, 2, 1, 2, 1, 3, 3));
//        int i = majorityNumber(Arrays.asList(2, 2, 3, 3, 1, 1, 1));
        int i = majorityNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 6,6,7,7,8));
        System.out.println(i);
    }
}
