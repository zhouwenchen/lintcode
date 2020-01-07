package com.lintcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. 子集
 * 中文English
 * 给定一个含不同整数的集合，返回其所有的子集。
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
 * 输入：[1,2,3]
 * 输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 挑战
 * 你可以同时用递归与非递归的方式解决么？
 *
 * 注意事项
 * 子集中的元素排列必须是非降序的，解集必须不包含重复的子集。
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>(),results);

        return results;
    }

    private static void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> results) {
        // 递归循环的出口
        if(index == nums.length){
            results.add(new ArrayList<>(subset));
            return;
        }
        // 递归的拆解   如何进入下一层
        subset.add(nums[index]);
        dfs(nums,index + 1,subset,results);

        // 不选nums[index]
        subset.remove(subset.size()-1);
        dfs(nums,index + 1,subset,results);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = subsets(new int[]{1, 2, 3});
        result.forEach(System.out::println);
    }
}
