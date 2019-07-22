package com.offer.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**  
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月9日 下午4:01:31 
 */
public class PrintMinNumber {
	public static String printMinNumber(int[] nums) {
		if (nums == null) {
			return "";
		}
		List<String> result = new ArrayList<String>();
		getAllCombine(0, nums, result);
		Collections.sort(result);
		return result.get(0);
	}
	
	private static void getAllCombine(int index, int[] nums, List<String> result) {
		if (index == nums.length - 1) {
			StringBuilder sb = new StringBuilder();
			for (int num : nums) {
				sb.append(num);
			}
			result.add(sb.toString());
			return;
		}

		// 记录已经出现第一部分的元素
		Set<Integer> ocur = new HashSet<Integer>();
		for (int i = index; i < nums.length; i++) {
			if (!(i != index && ocur.contains(nums[i]))) {
				ocur.add(nums[i]);
				swap(nums, i, index);
				getAllCombine(index + 1, nums, result);
				swap(nums, i, index);
			}
		}
	}

	private static void swap(int[] nums, int i, int j) {
		if (i != j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
	
	
	public static String printMinNumber2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		String[] strnums = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strnums[i] = String.valueOf(nums[i]);
		}

		// 排序数组
		Arrays.sort(strnums, (o1, o2) -> {
			return (o1 + o2).compareTo(o2 + o1);
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strnums.length; i++) {
			sb.append(strnums[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 32, 321 };
//		String minNumber = printMinNumber(nums);
		String minNumber = printMinNumber2(nums);
		System.out.println(minNumber);
	}
}
