package com.lintcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**  
 * 
39. 恢复旋转排序数组
给定一个旋转排序数组，在原地恢复其排序。

样例
Example1:
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
Example2:
[6,8,9,1,2] -> [1,2,6,8,9]

挑战
使用O(1)的额外空间和O(n)时间复杂度

说明
什么是旋转数组？

比如，原始数组为[1,2,3,4], 则其旋转数组可以是[1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class RecoverRotatedSortedArray {
	
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(4);
		nums.add(5);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		System.out.println("nums:" + nums);
//		recoverRotatedSortedArray(nums);
//		recoverRotatedSortedArray3(nums);
		System.out.println(nums);
	}

	public static void recoverRotatedSortedArray(List<Integer> nums) {
		int temp = nums.get(0);
		int i;
		// 找到第一个的最小值
		for (i = 0; i < nums.size(); i++) {
			if (nums.get(i) < temp) {
				break;
			}
		}
		
		if (i != nums.size()) {
			for (int j = 0; j < i; j++) {
				nums.add(nums.get(j));
			}
			nums.subList(0, i).clear();
		}
	}

	public static List<Integer> recoverRotatedSortedArray3(List<Integer> nums) {
		Collections.sort(nums);
		return null;
	}
}
