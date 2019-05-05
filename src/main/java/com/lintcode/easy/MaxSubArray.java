package com.lintcode.easy;

/**  
 * 41. 最大子数组
给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。

样例
样例1:
给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
样例2:
给出数组[1,2,3,4]，符合要求的子数组为[1,2,3,4]，其最大和为10

挑战
要求时间复杂度为O(n)

注意事项
子数组最少包含一个数
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class MaxSubArray {
	
	public static int maxSubArray(int[] nums) {
		int len = nums.length;
		if(len == 0){
			return 0;
		}
		int sum = nums[0];
		int res = sum;
		for(int i = 1;i < len;i++){
			if(sum > 0){
				sum +=nums[i];
			}else if(sum < 0){
				sum = nums[i];
			}
			res = Math.max(res,sum);
		}
		return res;
	}
	
	public static int maxSubArray1(int[] nums) {
		// write your code
		int max_ending_here = nums[0];
		int max_so_far = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max_ending_here = Math.max(nums[i], nums[i] + max_ending_here);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		return max_so_far;
	}
	
	public static int maxSubArray2(int[] nums) {
		// write your code
		int n = nums.length;
		int max = nums[0];
		for (int i = 1; i < n; i++)
			if (nums[i] > max)
				max = nums[i];
		if (max < 0)
			return max;
		int dp = 0, res = 0;
		for (int i = 0; i < n; i++) {
			dp += nums[i];
			if (dp < 0)
				dp = 0;
			if (dp > res)
				res = dp;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1, -2, 3, -4, 5, -6, 7, -8, 9 };
//		int[] nums = new int[]{-2,2,-3,4,-1,2,1,-5,3};
//		int[] nums = new int[]{-1,0,1};
//		int sum = maxSubArray(nums);
		int sum = maxSubArray2(nums);
		System.out.println(sum);
	}
}
