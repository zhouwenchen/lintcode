package com.offer.test;

/**  
 * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 * @author zhouwenchen@021.com  
 * @date 2019年7月15日 下午4:22:26 
 */
public class MaxValueOfGifts {
	
	public static int maxValueOfGifts(int[][] values) {
		if (values == null || values.length <= 0 || values[0].length <= 0) {
			return 0;
		}
		int row = values.length;
		int cols = values[0].length;

		// 1.使用一维数组的辅助空间，用于存放最大值
		int[] maxValue = values[0];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cols; j++) {
				int left = 0;
				int up = 0;
				if (i > 0) {
					up = maxValue[j];
				}
				if (j > 0) {
					left = maxValue[j - 1];
				}
				maxValue[j] = Math.max(up, left) + values[i][j];
			}
		}
		return maxValue[cols - 1];
	}

	public static void main(String[] args) {
		int[][] values = new int[][] { { 1, 10, 3, 8 }, { 12, 2, 9, 6 }, { 5, 7, 4, 11 }, { 3, 7, 16, 5 } };
		int maxValue = maxValueOfGifts(values);
		System.out.println(maxValue);
	}
}
