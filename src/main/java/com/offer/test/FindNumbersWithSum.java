package com.offer.test;

import java.util.ArrayList;
import java.util.List;

/**  
 * 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。 如果有多对数字的和等于s，则输出任意一对即可。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月18日 下午2:56:25 
 */
public class FindNumbersWithSum {
	
	public static List<Integer> findNumbersWithSum(int[] nums,int k) {
		if(nums == null || nums.length <= 1){
			return null; // 表示不能再
		}
		List<Integer> result = new ArrayList<Integer>();
		int start = 0;
		int end = nums.length - 1;
		while(start < end){
			if(nums[start] + nums[end] == k){
				result.add(nums[start]);
				result.add(nums[end]);
				return result;
			} else if(nums[start] + nums[end] > k){
				end--;
			} else {
				start++;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 4, 7, 11, 15 };
		List<Integer> lists = findNumbersWithSum(nums,15);
		for (Integer list : lists) {
			System.out.println(list);
		}
	}
}
