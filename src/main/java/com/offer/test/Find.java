package com.offer.test;

/**  
 * 在一个有序的二维数组中，查找某一个值是否在二维数组中
 * [{ 1, 2, 8, 9 }
 * { 2, 4, 9, 12 } 
 * { 4, 7, 10, 13 }
 * { 6, 8, 11, 15 }] 
 * @author zhouwenchen@021.com  
 * @date 2019年6月12日 下午4:27:17 
 */
public class Find {
	
	/**
	 * 默认选取的是右上角的数字
	 * @param arr
	 * @param key
	 * @return
	 */
	public static boolean find(int[][] arr, int key) {
		if (arr == null || arr.length <= 0) {
			return false;
		}
		// 先获取到 二维数组中的右上角的值
		int colum = arr[0].length - 1;
		int row = 0;
		while (row < arr.length && colum > 0) {
			if (arr[row][colum] == key) {
				return true;
			}
			if (arr[row][colum] > key) {
				colum--;
			} else {
				row++;
			}
		}

		return false;
	}
	
	/**
	 * 默认选择的是左下角的数字
	 * @param arr
	 * @param i
	 * @return
	 */
	private static boolean find2(int[][] arr, int key) {
		if (arr == null || arr.length < 0) {
			return false;
		}

		// 选择二维数组中的左下角的值
		int row = arr[0].length - 1;
		int colum = 0;
		while (row > 0 && colum < arr.length) {
			if (arr[row][colum] == key) {
				return true;
			}
			if (arr[row][colum] < key) {
				colum++;
			} else {
				row--;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
//		boolean result = find(arr,16);
		boolean result = find2(arr,15);
		System.out.println(result);
	}


}
