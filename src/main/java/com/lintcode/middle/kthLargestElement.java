package com.lintcode.middle;

import java.util.Arrays;

/*
在数组中找到第 k 大的元素。
你可以交换数组中的元素的位置

样例
样例 1：

输入：
n = 1, nums = [1,3,4,2]
输出：
4
样例 2：

输入：
n = 3, nums = [9,3,2,4,8]
输出：
4
挑战
要求时间复杂度为O(n)，空间复杂度为O(1)。
 * @Author zhouwenchen
 * @Date 20200507
 **/
public class kthLargestElement {

    /**
     * 先排序
     *
     * @param k
     * @param nums
     * @return
     */
    public static int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        // 排序
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 第二种方式，使用哦快速排序实现的
     * @param k
     * @param nums
     * @return
     */
    public static int kthLargestElement2(int k, int[] nums) {
        if (nums == null || nums.length == 0 || k < 0 || k > nums.length) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int target = nums.length - k;

        return partition(nums, start, end, target);
    }

    private static int partition(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[k];
        }
        int pivot = nums[(start + end) / 2];
        int left = start;
        int right = end;
        while (left <= right) {
            while (nums[left] < pivot) {
                left++;
            }
            while (nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (k <= right) {
            return partition(nums, start, right, k);
        }
        return partition(nums, left, end, k);
    }

    /**
     * 两个数组元素交换位置
     *
     * @param nums
     * @param left
     * @param right
     */
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2};
        int result = kthLargestElement2(1, nums);
        System.out.println(result);
    }
}
