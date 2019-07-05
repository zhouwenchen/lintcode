package com.offer.test;

/**  
 * 快速排序的算法
 * @author zhouwenchen@021.com  
 * @date 2019年6月25日 上午10:41:53 
 */
public class QuickSort {
	
	public static int quickSort(int[] nums, int start, int end) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if(start < end){
			int index = getIndex(nums, start, end);
			quickSort(nums, 0, index-1);
			quickSort(nums, index+1, end);
		}
		return 0;
	}
	
	private static int getIndex(int[] nums, int start, int end) {
		// 基准数据
		int tmp = nums[start];
		while(start < end){
			while(start < end && nums[end] >= tmp){
				end--;
			}
			nums[start] = nums[end];
			while(start < end && nums[start] <=tmp){
				start++;
			}
			nums[end] = nums[start];
			
		}
		nums[start] = tmp;
		return start;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 46, 30, 82, 90, 56, 17, 95, 15 };
		quickSort(nums, 0, nums.length - 1);
		for (int num : nums) {
			System.out.println(num);
		}
	}
}
