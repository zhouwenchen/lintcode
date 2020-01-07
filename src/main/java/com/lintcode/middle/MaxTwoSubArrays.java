package com.lintcode.middle;

import javax.validation.constraints.Max;
import java.util.Arrays;
import java.util.List;

/**
 * 42. 最大子数组 II
 * 中文English
 * 给定一个整数数组，找出两个 不重叠 子数组使得它们的和最大。
 * 每个子数组的数字在数组中的位置应该是连续的。
 * 返回最大的和。
 *
 * 样例
 * 例1:
 *
 * 输入:
 * [1, 3, -1, 2, -1, 2]
 * 输出:
 * 7
 * 解释:
 * 最大的子数组为 [1, 3] 和 [2, -1, 2] 或者 [1, 3, -1, 2] 和 [2].
 * 例2:
 *
 * 输入:
 * [5,4]
 * 输出:
 * 9
 * 解释:
 * 最大的子数组为 [5] 和 [4].
 * 挑战
 * 要求时间复杂度为 O(n)
 *
 * 注意事项
 * 子数组最少包含一个数
 */
public class MaxTwoSubArrays {

    public static int maxTwoSubArrays(List<Integer> nums) {
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size;i++){
            sum += nums.get(i);
            max = Math.max(max,sum - minSum);
            minSum = Math.min(sum,minSum);
            left[i] = max;
        }
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for(int i = size -1; i>= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;
        for(int i = 0; i < size - 1; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int sum = maxTwoSubArrays(Arrays.asList(1, 3, -1, 2, -1, 2));
        System.out.println(sum);
    }
}
