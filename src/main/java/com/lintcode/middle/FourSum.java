package com.lintcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 58. 四数之和
 * 给一个包含n个数的整数数组S，在S中找到所有使得和为给定整数target的四元组(a, b, c, d)。
 *
 * 样例
 * 例1:
 *
 * 输入:[2,7,11,15],3
 * 输出:[]
 *
 * 例2:
 *
 * 输入:[1,0,-1,0,-2,2],0
 * 输出:
 * [[-1, 0, 0, 1]
 * ,[-2, -1, 1, 2]
 * ,[-2, 0, 0, 2]]
 * 注意事项
 * 四元组(a, b, c, d)中，需要满足a <= b <= c <= d
 *
 * 答案中不可以包含重复的四元组。
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null && nums.length < 4){
            return result;
        }

        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n - 3; i++){
            if(i > 0 && nums[i] == nums[i -1]){
                continue;
            }
            for(int j = i + 1; j < n - 2; j++){
                if(j > i+1 && nums[j] == nums[j - 1]){
                    continue;
                }
                for(int l = j + 1,r = n -1; l < r; ++l){
                    if(l > j+1 && nums[l] == nums[l - 1]){
                        continue;
                    }
                    while (r > l && nums[i] + nums[j] + nums[l] + nums[r] > target){
                        r--;
                    }
                    if(l >= r){
                        break;
                    }
                    if(nums[i] + nums[j] + nums[l] + nums[r] == target){
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[l]);
                        item.add(nums[r]);
                        result.add(item);
                    }
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        List<List<Integer>> result = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        result.stream().forEach(System.out::println);
    }
}
