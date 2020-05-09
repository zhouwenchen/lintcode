package com.lintcode.middle;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;
import java.util.List;

/**
 * 15. 全排列
 * 中文English
 * 给定一个数字列表，返回其所有可能的排列。
 *
 * 样例
 * 样例 1：
 *
 * 输入：[1]
 * 输出：
 * [
 *   [1]
 * ]
 * 样例 2：
 *
 * 输入：[1,2,3]
 * 输出：
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * 挑战
 * 使用递归和非递归分别解决。
 *
 * 注意事项
 * 你可以假设没有重复数字。
 */
public class Permute {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null){
            return results;
        }
        dfs(nums,new boolean[nums.length],new ArrayList<Integer>(),results);
        return results;
    }

    private static void dfs(int[] nums, boolean[] visited, ArrayList<Integer> permutation, List<List<Integer>> results) {
        if(nums.length == permutation.size()){
            results.add(new ArrayList<>(permutation));
            return;
        }
        for(int i = 0; i < nums.length;i++){
            if(visited[i]){
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        permute.forEach(System.out::println);
    }
}
