package com.offer.test;

/**  
 * 仅用于测试之用，不做具体的介绍
 * @author zhouwenchen@021.com  
 * @date 2019年7月18日 上午11:20:32 
 */
public class Atest {
	
	public static void main(String[] args) {
		int[] nums = new int[] { 2, 4, 3, 6, 3, 2, 5, 5 };
		int sum = 0;
		for (int i = 1; i < nums.length; i++) {
			System.err.println(nums[i] + "\t" + Integer.toBinaryString(nums[i]));
			if (i == 1) {
				sum = nums[0];
			}
			sum ^= nums[i];
		}
		System.out.println(Integer.toBinaryString(sum));
		// 判断数组中和  sum相同位的1 
		
		System.out.println("===============");
		
		// 10 表示的是二进制的
		int unsignedInt = Byte.toUnsignedInt((byte) sum);
		System.out.println(unsignedInt);
		System.out.println(4 ^ unsignedInt);
	}
}