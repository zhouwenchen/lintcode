package com.offer.test;

/**  
 * 机器人运动范围
 * 地上有一个m行n列的方格， 一个机器人从坐标（0,0）的格子开始移动，它每次可以向左，向右，向上，向下移动一格， 但不能进入行坐标和列坐标的位数之和大于k的格子， 
 * 例如：当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18； 但它不能进入方格（35,38），因为3 + 5+3+8 = 19.请问该机器人最多能到达多少个格子？
 * @author zhouwenchen@021.com  
 * @date 2019年6月17日 上午11:36:52 
 */
public class MovingCount {
	
	/**
	 * 
	 * @param m m行
	 * @param n 列
	 * @param k 行列之和不大于k
	 */
	public static int movingCount(int m, int n, int k) {
		// 默认都初始化为false
		boolean isVisited[][] = new boolean[m][n];

		int count = moveCount(0, 0, k, isVisited);
		return count;
	}
	
	private static int moveCount(int i, int j, int k, boolean[][] isVisited) {
		int count = 0;
		int m = isVisited.length;
		int n = isVisited[0].length;
		if (i >= 0 && i < m && j >= 0 && j < n && !isVisited[i][j] && isSum(i, j, k)){
			isVisited[i][j] = true;
			count = 1 + moveCount(i-1, j, k, isVisited) 
					  + moveCount(i, j-1, k, isVisited)
					  + moveCount(i+1, j, k, isVisited)
					  + moveCount(i, j+1, k, isVisited);
		}
		return count;
	}

	private static boolean isSum(int i, int j, int k) {
		int sum = 0;
		while (i > 0) {
			sum = sum + i % 10;
			i = i / 10;
		}
		while (j > 0) {
			sum = sum + j % 10;
			j = j / 10;
		}
		if (sum <= k) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int m = 20;
		int n = 20;
		int k = 18;

		int count = movingCount(m, n, k);
		System.out.println(count);
	}
}
