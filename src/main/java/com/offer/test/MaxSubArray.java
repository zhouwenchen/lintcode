package com.offer.test;

/**  
 * 连续子数组中的最大和
 * @author zhouwenchen@021.com  
 * @date 2019年7月9日 下午3:21:16 
 */
public class MaxSubArray {
	
	public static Integer maxSubArray(Integer[] nums) {
		int sum = 0;
		int maxSum = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (sum < 0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
//		Integer[] nums = new Integer[]{1,-2,3,10,-4,7,2,-5};
		Integer[] nums = new Integer[]{-1,-1,-2};
		Integer sum = maxSubArray(nums);
		System.out.println(sum);
	}
}
