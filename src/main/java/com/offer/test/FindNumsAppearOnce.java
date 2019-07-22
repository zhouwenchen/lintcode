package com.offer.test;

/**  
 * 数组中数字出现的次数
 * 数组中只出现一次的两个数字。一个整形数组除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度为O(n)，空间复杂度为O(1)。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月18日 上午11:47:05 
 */
public class FindNumsAppearOnce {
	public static void findNumsAppearOnce(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return;
		}
		int resultXOR = 0;
		for (int i = 0; i < length; i++) {
			resultXOR ^= nums[i];
		}
		int[] nums1 = new int[length];
		int[] nums2 = new int[length];
		int index = FindFirstOne(resultXOR);
		// 再次遍历
		int m = 0;
		int n = 0;
		for (int i = 0; i < length; i++) {
			// 判断数组中的每一个数，是否是和resultXOR相同位置上的数据是否一样
			if (BitOne(nums[i], index)) {
				nums1[m++] = nums[i];
			} else {
				nums2[n++] = nums[i];
			}
		}
		
		// 获取到nums1 和 nums2 中的数据，分别在异或运算
		int resultXOR1 = 0;
		int resultXOR2 = 0;
		for (int i = 0; i < length; i++) {
			resultXOR1 ^= nums1[i];
		}
		for (int i = 0; i < length; i++) {
			resultXOR2 ^= nums2[i];
		}
		System.out.println(resultXOR1+"\t" + resultXOR2);
	}
	
	private static boolean BitOne(int number, int bit) {
		number = number >> bit;
		int result = number & 1;
		return result == 0 ? false : true;
	}

	private static int FindFirstOne(int resultXOR) {
		int oneIndex = 0;
		// 需要防止溢出
		while (((resultXOR) & 1) == 0 && (oneIndex < 8)) {
			resultXOR = resultXOR >> 1;
			oneIndex++;
		}
		return oneIndex;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 4, 3, 6, 3, 2, 5, 5 };
		findNumsAppearOnce(nums);
	}
}
