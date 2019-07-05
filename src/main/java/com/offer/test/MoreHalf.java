package com.offer.test;

import java.util.HashMap;
import java.util.Map;

/**  
 * 数组中出现次数超过一半的数字
 * 数组中出现的数值的个数，超过数组个数的一半
 * {1,2,3,2,2,2,5,4,2}
 * @author zhouwenchen@021.com  
 * @date 2019年6月24日 下午7:21:11 
 */
public class MoreHalf {
	
	/**
	 * 遍历，使用for循环，然后获取到每一个值的计数存入到map，之后遍历map获取值大于数组长度的一半的值-----效率很差
	 * @param nums
	 * @return
	 */
	public static int moreHalf(int[] nums){
		if(nums == null || nums.length == 0){
			return -1;
		}
		Map<Integer,Integer> map = new HashMap<>();
		// 循环遍历，将值放入到map集合中，但是之后还是需要遍历map集合判断值是否有超过数组长度的一半的
		for (int num : nums) {
			if(map.get(num) != null){
				map.put(num, map.get(num) +1);
			} else {
				map.put(num,1);
			}
		}
		for (Integer key : map.keySet()) {
			Integer value = map.get(key);
			int half = nums.length >>1;
			if(value >half){
				return key;
			}
		}
		return -1;
	}
	
	/**
	 * 1.先排序，获取到中位数的值，即是数据中长度大于数组长度一半的值
	 * @param nums
	 * @return
	 */
	public static int moreHalf1(int[] nums, int start, int end) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		start = 0;
		end = nums.length -1;
		int index = Partition(nums, start, end);
		int mid = nums.length >> 1;
		while (index != mid) {
			if (index > mid) {
				index = Partition(nums, start, index - 1);
			} else {
				index = Partition(nums, index + 1, end);
			}
		}
		
		// 排序完成之后，查找中位数的值
		return nums[index];
	}
	
	/**
	 *  
	 */
	private static int Partition(int[] nums, int start, int end) {
		int pivotkey = nums[start];
		int orgin = start;
		while (start < end) {
			while (start < end && nums[end] >= pivotkey) {
				end--;
			}
			while (start < end && nums[start] < pivotkey) {
				start++;
			}
			swap(nums, start, end);
		}
		swap(nums, start, end);
		swap(nums, orgin, end);
		return end;
	}

	private static void swap(int[] nums, int start, int end) {
		if(start == end){
			return;
		}
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
//		int[] nums = new int[] {};
//		int count = moreHalf(nums);
		
		int count = moreHalf1(nums,0,nums.length - 1);
		System.out.println(count);
	}
}
