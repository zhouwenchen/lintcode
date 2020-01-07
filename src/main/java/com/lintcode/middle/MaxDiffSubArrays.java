package com.lintcode.middle;

import java.util.Arrays;

/**
 * 45. 最大子数组差
 * 中文English
 * 给定一个整数数组，找出两个不重叠的子数组A和B，使两个子数组和的差的绝对值|SUM(A) - SUM(B)|最大。
 *
 * 返回这个最大的差值。
 *
 * 样例
 * 例1:
 *
 * 输入:[1, 2, -3, 1]
 * 输出:6
 * 解释:
 * 子数组是 [1,2] 和[-3].所以答案是 6.
 * 例2:
 *
 * 输入:[0,-1]
 * 输出:1
 * 解释:
 * 子数组是 [0] 和 [-1].所以答案是 1.
 * 挑战
 * 时间复杂度为O(n)，空间复杂度为O(n)
 *
 * 注意事项
 * 子数组最少包含一个数
 */
public class MaxDiffSubArrays {
    public static int maxDiffSubArrays(int[] nums) {

        int size = nums.length;
        int[] left_max = new int[size];
        int[] left_min = new int[size];
        int[] right_max = new int[size];
        int[] right_min = new int[size];
        int[] copy = new int[size];
        for(int i = 0; i < size; i++){
            copy[i] = -1 * nums[i];
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        // left_max
        for(int i = 0; i < size; i++){
            sum += nums[i];
            max = Math.max(max,sum - minSum);
            minSum = Math.min(sum,minSum);
            left_max[i] = max;
        }

        // right_max
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = size - 1; i >= 0; i--){
            sum += nums[i];
            max = Math.max(max,sum -minSum);
            minSum = Math.min(sum,minSum);
            right_max[i] = max;
        }

        // left_min
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = 0; i< size - 1; i++){
            sum += copy[i];
            max = Math.max(max,sum - minSum);
            minSum = Math.min(sum, minSum);
            left_min[i] = -1 * max;
        }
        // right_min
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = size -1; i >= 0;i--){
            sum += copy[i];
            max = Math.max(max,sum - minSum);
            minSum = Math.min(sum,minSum);
            right_min[i] = -1 * max;
        }
        int diff = 0;
        for(int i = 0; i < size - 1; i++){
            diff = Math.max(diff,Math.abs(left_max[i]-right_min[i+1]));
            diff = Math.max(diff,Math.abs(left_min[i] - right_max[i+1]));
        }

        return diff;
    }

    public static void main(String[] args) {
//        int diffmax = maxDiffSubArrays(new int[]{1, 2, -3, 1});
//        int diffmax = maxDiffSubArrays(new int[]{-5,3,-4,0,0,0,-1,20,1,1,-1,-1,-1,-1,-1});
        int diffmax = maxDiffSubArrays(new int[]{101,33,44,-55,-67,-78,101,33,43});
        System.out.println(diffmax);
    }
}
