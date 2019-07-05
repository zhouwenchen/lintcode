package com.offer.test;

/**  
 * 连续子数组的最大和
 * 
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。例如输入的数组为{1,-2,3,10,-4,7,2,-5}，和最大的子数组为{3,10,-4,7,2}，因此输出为该子数组的和18。
 * 
 * 使用的是动态规划的方式实现的。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月25日 下午3:43:34 
 */
public class FindGreatestSumOfSubArray {
	
	public static int findGreatestSumOfSubArray(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int currSum = 0;
		int greatestSum = Integer.MIN_VALUE;
		for (int arr : array) {
			if (currSum <= 0) {
				currSum = arr;
			} else {
				currSum += arr;
			}

			if (currSum > greatestSum) {
				greatestSum = currSum;
			}
		}

		return greatestSum;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
		System.out.println(findGreatestSumOfSubArray(array));
	}
}