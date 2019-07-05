package com.offer.test;

/**  
 * 
 * 减绳子
 * 
 * 给你一根长度为n的绳子，请把绳子剪成m段（m，n都是大于1 的整数）。每段绳子长度的可能最大乘积是多少。
 * 使用 动态规划-贪婪算法
 * @author zhouwenchen@021.com  
 * @date 2019年6月17日 下午2:24:13 
 */
public class MaxProductAfterCuttingDemo {
	
	/**
	 * 使用的是动态规划
	 * @param len
	 * @return
	 */
	public static int axProductAfterCutting(int len) {
		if (len < 2) {
			return 0;
		}
		if (len == 2) {
			return 1;
		}
		if (len == 3) {
			return 2;
		}

		int[] result = new int[len + 1];
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		result[3] = 3;

		// 自低向上开始求解
		int max = 0;
		for (int i = 4; i <= len; i++) {
			max = 0;
			for (int j = 0; j <= i / 2; j++) {
				int tempResult = result[j] * result[i - j];
				max = max < tempResult ? tempResult : max;
				result[i] = max;
			}
		}
		max = result[len];
		return max;
	}
	
	/**
	 * 贪婪算法的实现
	 * @param len
	 * @return
	 */
	public static int maxProductWithGreedy(int len) {
		if (len < 2) {
			return 0;
		}
		if (len == 2) {
			return 1;
		}
		if (len == 3) {
			return 2;
		}
		// 啥也不管,先尽可能减去长度为3的段
		int timeOfThree = len / 3;

		// 判断还剩下多少，进行判断
		if (len - timeOfThree * 3 == 1) {
			timeOfThree -= 1;
		}
		int timeOfTwo = (len - timeOfThree * 3) / 2;
		return (int) ((Math.pow(3, timeOfThree)) * (Math.pow(2, timeOfTwo)));
	}
	
	public static void main(String[] args) {
		System.out.println(axProductAfterCutting(9));// axProductAfterCutting(8)=18
//		System.out.println(maxProductWithGreedy(9)); // maxProductWithGreedy(8)=18
	}
}
