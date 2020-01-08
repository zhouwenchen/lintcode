package com.lintcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 三数之和
 * 中文English
 * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 *
 * 样例
 * 例1:
 *
 * 输入:[2,7,11,15]
 * 输出:[]
 * 例2:
 *
 * 输入:[-1,0,1,2,-1,-4]
 * 输出:[[-1, 0, 1],[-1, -1, 2]]
 * 注意事项
 * 在三元组(a, b, c)，要求a <= b <= c。
 *
 * 结果不能包含重复的三元组。
 */
public class ThreeSum {
    /**
     * 思路：
     *     1.数组排序
     *     2.
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3){
            return result;
        }
        // 数组排序
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2; i++){
            // 跳过重复的元素
            if(i > 0 && nums[i] == nums[i -1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i]; // TODO 为啥？

            twoSum(nums,left,right,target,result);
        }
        return result;
    }

    private static void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> result) {
        while (left < right){
            if(nums[left] + nums[right] == target){
                List<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                result.add(triple);

                left++;
                right--;

                // 需要跳过重复的元素
                while (left < right && nums[left] == nums[left-1]){
                    left++;
                }
                while (left < right && nums[right] == nums[right+1]){
                    right--;
                }
            } else if(nums[left] + nums[right] < target){
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        result.stream().forEach(System.out::print);
    }
}
