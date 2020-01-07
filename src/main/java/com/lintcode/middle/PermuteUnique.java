package com.lintcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 16. 带重复元素的排列
 * 中文English
 * 给出一个具有重复数字的列表，找出列表所有不同的排列。
 *
 * 样例
 * 样例 1：
 *
 * 输入：[1,1]
 * 输出：
 * [
 *   [1,1]
 * ]
 * 样例 2：
 *
 * 输入：[1,2,2]
 * 输出：
 * [
 *   [1,2,2],
 *   [2,1,2],
 *   [2,2,1]
 * ]
 * 挑战
 * 使用递归和非递归分别完成该题。
 */
public class PermuteUnique {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null){
            return results;
        }
        Arrays.sort(nums); // 先排序，
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);
        return results;
    }

    private static void dfs(int[] nums, boolean[] visited, ArrayList<Integer> permutation, List<List<Integer>> results) {
        if(nums.length == permutation.size()){
            results.add(new ArrayList<Integer>(permutation));
            return ;
        }

        for(int i = 0; i < nums.length;i++){
            if(visited[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){ // 判断相邻的是否相等
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums,visited,permutation,results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> result = permuteUnique(new int[]{1, 2, 2});
        List<List<Integer>> result = permuteUnique(new int[]{3,3,0,3});
        result.forEach(System.out::println);
    }
}
