package com.lintcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 子集 II
 * 中文English
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集。
 *
 * 样例
 * 样例 1：
 *
 * 输入：[0]
 * 输出：
 * [
 *   [],
 *   [0]
 * ]
 * 样例 2：
 *
 * 输入：[1,2,2]
 * 输出：
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 挑战
 * 你可以同时用递归与非递归的方式解决么？
 *
 * 注意事项
 * 子集中的每个元素都是非降序的
 * 两个子集间的顺序是无关紧要的
 * 解集中不能包含重复子集
 */
public class SubsetsWithDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null){
            return results;
        }
        Arrays.sort(nums);
        helper(nums,0,new ArrayList<>(),results);
        return results;
    }

    private static void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results) {
       results.add(new ArrayList<>(subset));
       for(int i = startIndex; i < nums.length;i++){
           if(i != startIndex && nums[i] == nums[i - 1]){
               continue;
           }
           subset.add(nums[i]);
           helper(nums,i + 1,subset,results);
           subset.remove(subset.size()-1);
       }
    }

    public static void main(String[] args) {
        List<List<Integer>> results = subsetsWithDup(new int[]{1, 2, 3});
        results.forEach(System.out::println);
    }
}
