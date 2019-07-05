package com.lintcode.easy;

/**  
 * 
373. 奇偶分割数组
中文English
分割一个整数数组，使得奇数在前偶数在后。

样例
样例1:

输入: [1,2,3,4]
输出: [1,3,2,4]
样例2:

输入: [1,4,2,3,5,6]
输出: [1,3,5,4,2,6]
挑战
在原数组中完成，不使用额外空间。

注意事项
答案不唯一。你只需要给出一个合法的答案。
 * @author zhouwenchen@021.com  
 * @date 2019年6月3日 下午2:31:08 
 */
public class PartitionArray {
	public static void main(String[] args) {
//		int[] nums = new int[] { 1, 2, 3, 4 };
		int[] nums = new int[] { 1,4,2,3,5,6 };
		// int[] nums = new int[]{};

		partitionArray(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t");
		}
	}

	public static void partitionArray(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			while (start < end && nums[start] % 2 == 1) {
				start++;
			}
			while (start < end && nums[end] % 2 == 0) {
				end--;
			}
			if (start < end) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				start++;
				end--;
			}
		}
	}
}
