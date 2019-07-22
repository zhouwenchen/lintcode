package com.offer.test;

/**  
 * 数组中的逆序对（Java）
 * 
 * 在数组中的两个数字如果前面的数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 例如在数组{7, 5, 6, 4}中，一共存在5个逆序对，分别是（7，6）、（7，5）、（7，4）、（6、4）和（5，4）
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月16日 下午5:11:43 
 */
public class InversePairs {
	
	private static int reversePair = 0; // 统计数组中的逆序对

	public static int inversePairs(int[] arr) {
		if (arr == null || arr.length <= 0) {
			return 0;
		}

		sort(arr, 0, arr.length - 1);
		return reversePair;
	}

	private static void sort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) >> 1;
			sort(arr, start, mid);
			sort(arr, mid + 1, end);
			merger(arr, start, mid, mid + 1, end);
		}
	}

	private static void merger(int[] arr, int start1, int end1, int start2, int end2) {
		int len = end2 - start1 + 1;
		int[] nums = new int[len];
		int k = end2 - start1 + 1;
		int i = end1;
		int j = end2;

		while (i >= start1 && j >= start2) {
			if (arr[i] > arr[j]) {
				nums[--k] = arr[i--];
				reversePair = reversePair + (j - start2 + 1);
			} else {
				nums[--k] = arr[j--];
			}
		}
		for (; i >= start1; i--) {
			nums[--k] = arr[i];
		}
		for (; j >= start2; j--) {
			nums[--k] = arr[j];
		}

		for (int m = 0; m < len; m++) {
			arr[start1++] = nums[m];
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 7, 5, 6, 4 };
		int total = inversePairs(arr);
		System.out.println(total);
	}
}
