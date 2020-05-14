package com.lintcode.easy;

import java.util.Arrays;
import java.util.List;

/**
 * 44. 最小子数组
 * 中文English
 * 给定一个整数数组，找到一个具有最小和的连续子数组。返回其最小和。
 * <p>
 * 样例
 * 样例 1
 * <p>
 * 输入：[1, -1, -2, 1]
 * 输出：-3
 * 样例 2
 * <p>
 * 输入：[1, -1, -2, 1, -4]
 * 输出：-6
 * 注意事项
 * 子数组最少包含一个数字
 *
 * @Author zhouwenchen
 * @Date 20200511
 **/
public class MinSubArray {

    public static int minSubArray(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            ans = Math.min(ans, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int result = minSubArray(Arrays.asList(1, -1, -2, 1));
        System.out.println(result);
    }
}
