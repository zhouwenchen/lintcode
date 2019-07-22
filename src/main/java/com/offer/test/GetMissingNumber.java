package com.offer.test;

/**  
 * 0-n-1中缺失的数字
 * 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0-n-1之内。在范围0-n-1内的n-1个数字有且只有一个数字不在该数组中，请找出这个数字。
 * @author zhouwenchen@021.com  
 * @date 2019年7月17日 上午9:51:09 
 */
public class GetMissingNumber {
	public static int getMissingNumber(int[] nums) {
		if(nums == null || nums.length <=0){
			return -1; // -1 表示的是不存在
		}
		int loc = getMissingNum(nums,0,nums.length-1);
		return loc;
	}
	
	private static int getMissingNum(int[] nums, int start, int end) {
		int mid = (start + end) >> 1;
		int loc = -1;
		if(nums[mid] > mid){
			if(mid-1==0){
				return 0;
			} else if(nums[mid-1] == mid-1){
				return mid;
			} else {
				loc = getMissingNum(nums, start, mid-1);
			}
		} else if(nums[mid] == mid){
			loc = getMissingNum(nums, mid+1, end);
		}
		return loc;
	}

	public static void main(String[] args) {
//		int[] nums = new int[]{0,1,2,4,5,6,7}; // 3
//		int[] nums = new int[]{0,1,2,3,4,6,7}; // 5
//		int[] nums = new int[]{1,2,3,4,5,6,7}; // 0
		int[] nums = new int[]{0,1,2,3,4,5,7}; // 6
		int loc = getMissingNumber(nums);
		System.out.println(loc);
	}
}
