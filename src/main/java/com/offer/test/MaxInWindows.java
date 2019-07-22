package com.offer.test;

import java.util.ArrayList;

/**  
 * 队列的最大值
 * 
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，{2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，{2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月18日 下午8:41:20 
 */
public class MaxInWindows {
	
	public static ArrayList<Integer> maxInWindows(int[] nums, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (nums == null || k <= 0) {
			return list;
		}
		int i = 0; // 滑动窗口的开始位置
		int j = k - 1; // 滑动窗口的结束位置
		while (j <= nums.length - 1) {
			list.add(maxValue(nums, i, j));
			i += 1;
			j += 1;
		}
		return list;
	}
	
	private static Integer maxValue(int[] nums, int i, int j) {
		int temp = Integer.MIN_VALUE;
		for (int k = i; k <= j; k++) {
			if (temp < nums[k]) {
				temp = nums[k];
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 4, 2, 6, 2, 5, 1 };
		ArrayList<Integer> lists = maxInWindows(nums, 3);
		System.out.println(lists);
	}
}
