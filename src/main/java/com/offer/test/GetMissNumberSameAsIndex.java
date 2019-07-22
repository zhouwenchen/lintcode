package com.offer.test;

/**  
 * 数组中的数值和数组下标相等的值
 * 在排序数组中，查找值和数组小标相等的值
 * int[] nums = new int[]{-3,-1,1,3,5};
 * @author zhouwenchen@021.com  
 * @date 2019年7月17日 上午10:20:32 
 */
public class GetMissNumberSameAsIndex {
	public static int getMissNumberSameAsIndex(int[] nums) {
		int loc = -1;
		if(nums == null || nums.length <=0){
			return loc;
		}
		int left = 0;
		int right = nums.length - 1;
		while(left <= right){
			int mid = left + (( right - left) >> 1);
			if(nums[mid] == mid){
				return mid;
			}
			if(nums[mid] > mid){
				right = mid -1;
			}
			if(nums[mid] < mid){
				left = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{-3,-1,1,2,4,5};
		int loc = getMissNumberSameAsIndex(nums);
		System.out.println(loc);
	}
}
