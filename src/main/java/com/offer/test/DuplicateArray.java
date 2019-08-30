package com.offer.test;

/**  
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月11日 下午7:38:46 
 */
public class DuplicateArray {

	public static boolean duplicate(int[] arr) {
		// 条件判断，数组是否为空
		if (arr.length <= 0 || arr == null) {
			return false;
		}

		// 判断数组中数据是否满足条件要求（取值范围在0-n-1之间）
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr.length || arr[i] < 0) {
				return false;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			while (i != arr[i]) {
				// 替换
				if (arr[i] == arr[arr[i]]) {
					System.out.println(arr[i]);
					return true;
				} else {
					int temp = arr[i];
					arr[i] = arr[arr[i]];
					arr[temp] = temp;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 1, 0, 2, 5, 3 };
		boolean b = duplicate(arr);
		System.out.println(b);
	}
}
