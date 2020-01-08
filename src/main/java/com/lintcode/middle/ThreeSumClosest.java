package com.lintcode.middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 59. 最接近的三数之和
 * 中文English
 * 给一个包含 n 个整数的数组 S, 找到和与给定整数 target 最接近的三元组，返回这三个数的和。
 *
 * 样例
 * 例1:
 *
 * 输入:[2,7,11,15],3
 * 输出:20
 * 解释:
 * 2+7+11=20
 * 例2:
 *
 * 输入:[-1,2,1,-4],1
 * 输出:2
 * 解释:
 * -1+2+1=2
 * 挑战
 * O(n^2) 时间, O(1) 额外空间。
 *
 * 注意事项
 * 只需要返回三元组之和，无需返回三元组本身
 */
public class ThreeSumClosest {
    /**
     * 以下考虑是错误的 TODO 写的是和目标值相邻的三个元素 的和
     * -- 1.先数组排序
     * -- 2.目标值-数组值 = 差值
     * -- 3.根据差值排序，存入到 map 中 map<差值，数组值>
     */
    public static int threeSumClosest(int[] nums, int target) {
//        int result = 0;
//        if(nums == null && nums.length < 3){
//            return result;
//        }
//
//        Arrays.sort(nums);
//        Map<Integer,Integer> map = new HashMap<>();
//        int[] arr = new int[nums.length];
//        for(int i = 0; i < nums.length; i++){
//            int key = Math.abs(target - nums[i]);
//            map.put(key,nums[i]);
//            arr[i] = key;
//        }
//        Arrays.sort(arr);
//
//        int sum = 0;
//        for(int i = 0; i < 3; i++){
//            sum += map.get(arr[i]);
//        }

        if(nums == null || nums.length < 3){
            return -1; // 表示没有找到
        }
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length ; i++){
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end){
                int sum = nums[start] + nums[i] + nums[end];
                if(Math.abs(target - sum) < Math.abs(target - bestSum)){
                    bestSum = sum;
                }
                if(sum < target){
                    start++;
                }else{
                    end--;
                }
            }
        }

        return bestSum;
    }

    public static void main(String[] args) {
        int i = threeSumClosest(new int[]{2, 7, 11, 15}, 3);
//        int i = threeSumClosest(new int[]{4,4,4,7}, 12);
        System.out.println(i);
    }
}
