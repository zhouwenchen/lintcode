package com.offer.test;

/**  
 * 　在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或者3。
 * @author zhouwenchen@021.com  
 * @date 2019年6月12日 下午3:41:56 
 */
public class FindDuplication {
	public static int findDuplication(int[] arr) {
		if (arr == null || arr.length <= 0) {
			System.out.println("数组的长度不满足条件");
			return -1;
		}
		// 对数组中的数据进行校验，满足的条件是arr[i] > 0 && arr[i] < arr.length;
		for (int a : arr) {
			if (a < 1 || a > arr.length - 1) {
				System.out.println("数字超出了范围");
				return -1;
			}
		}

		// 使用类似二分查找的方法实现
		int low = 1;
		int high = arr.length - 1;
		int mid, count;
		while (low <= high) {
			mid = ((high - low) >> 2) + low;
			count = countRange(arr, low, mid);
			if (low == high) {
				if (count > 1) {
					return low;
				} else {
					break;
				}
			}
			if (count > mid - low + 1) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	/**
	 * 统计arr中的在范围low和mid中的数据的长度
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private static int countRange(int[] arr, int low, int high) {
		if (arr == null) {
			return 0;
		}
		int count = 0;
		for (int a : arr) {
			if (a >= low && a <= high) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
		int result = findDuplication(arr);
		System.out.println(result);
	}
}
