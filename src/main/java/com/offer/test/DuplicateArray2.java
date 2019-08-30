package com.offer.test;

/**  
 * 不修改数组找出重复的数字
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月11日 下午7:38:46 
 */
public class DuplicateArray2 {

	public static int duplicate(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;// 表示没有找到
		}
		for (int a : arr) {
			if (a < 1 || a > arr.length - 1) {
				System.out.println("数组中的值不满足要求");
				return -1;
			}
		}

		// 使用二分法实现查找
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int count = 0;
		while (low <= high) {
			mid = ((high - low) >> 2) + low;
			count = countRange(arr, low, mid);
			if (low == high) {
				if (count > 1)
					return low;
				else
					break; // 必有重复，应该不会出现这种情况吧？
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
	 * 
	 * @param arr
	 * @param start
	 * @param mid
	 * @return
	 */
	private static int countRange(int[] arr, int start, int end) {
		int count = 0;
		for (int a : arr) {
			if (a >= start && a <= end) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 5, 4, 1, 2, 6, 7, 7 };
		int b = duplicate(arr);
		System.out.println(b);
	}
}
