package com.lintcode.middle;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *61. 搜索区间
 * 中文English
 * 给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
 *
 * 如果目标值不在数组中，则返回[-1, -1]
 *
 * 样例
 * 例1:
 *
 * 输入:
 * []
 * 9
 * 输出:
 * [-1,-1]
 *
 * 例2:
 *
 * 输入:
 * [5, 7, 7, 8, 8, 10]
 * 8
 * 输出:
 * [3, 4]
 * 挑战
 * 时间复杂度 O(log n)
 */
public class SearchRange {
    /**
     * 思路1：从最小值和最大值开始进行比较
     * 思路2：使用二分查找法实现
     */
    public static int[] searchRange(int[] A, int target) {
        int[] result = new int[]{-1,-1};
        int len = A.length;
        if(A == null && target < A[0] &&  target > A[len - 1]){
            return result;
        }
        int start = 0;
        int end = len - 1;
        while (start <= end){
            if(target == A[start] && target == A[end]){
                result[0] = start;
                result[1] = end;
                return result;
            }
            if(target > A[start]){
                start++;
            }
            if(target < A[end]){
                end--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] A = new int[]{5, 7, 7, 8, 8, 10};
        int[] A = new int[]{};
        int[] range = searchRange(A, 8);
//        Arrays.stream(A).forEach(o-> System.out.print(o+"\t"));
        Arrays.stream(range).forEach(o-> System.out.print(o+"\t"));
    }
}
