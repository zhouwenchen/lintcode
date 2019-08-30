package com.offer.test;

/**  
 * 寻找已经排序号的旋转数组中的最小的值
 * @author zhouwenchen@021.com  
 * @date 2019年6月14日 下午2:24:38 
 */
public class FindMidNum {
	
	public static int findMidNum(int[] arr) {
		if (arr == null) {
			// 表示不存在
			return -1;
		}
		// 如果第一个元素等于最后一个元素的话，就有可能存在多个。形如{1,1,1,2,3,4,5,6,7,8}旋转之后的数组是{,1,1,2,3,4,5,6,7,8,1}
		if (arr[0] == arr[arr.length - 1]) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i + 1] < arr[i]) {
					return arr[i + 1];
				}
			}
		}
		// 1.0 使用二分查找法
		return searchMid(arr,0,arr.length-1);
	}
	
	private static int searchMid(int[] arr, int min, int max) {
		if (min + 1 == max) {
			return arr[max];
		}
		int mid = (min + max) >> 1;
		// 当中间值大于索引最小值，说明最小值是在中间值的后半部分
		if (arr[mid] >= arr[min] && arr[mid] > arr[max]) {
			return searchMid(arr, mid, max);
		} else {
			return searchMid(arr, min, mid);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{3,4,5,1,2};
//		int[] arr = new int[]{8,9,10,2,3,4,5,6,7};
		
		// 如果旋转数组的前后的值一样的情况下，只能遍历数组。特殊情况(不适合使用二分查找的方法)
//		int[] arr = new int[]{1,1,1,1,1,1,1,1,1,2,0};
		
		int minNum = findMidNum(arr);
		System.out.println(minNum);
	}
}
