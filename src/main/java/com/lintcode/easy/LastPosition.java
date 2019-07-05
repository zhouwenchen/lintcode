package com.lintcode.easy;

/**  
 * 
 * 458. 目标最后位置
中文English
给一个升序数组，找到 target 最后一次出现的位置，如果没出现过返回 -1

样例
样例 1：

输入：nums = [1,2,2,4,5,5], target = 2
输出：2
样例 2：

输入：nums = [1,2,2,4,5,5], target = 6
输出：-1
 * @author zhouwenchen@021.com  
 * @date 2019年6月3日 下午4:59:48 
 */
public class LastPosition {
	public static int lastPosition(int[] nums, int target) {
		if (nums.length == 0 || nums[nums.length - 1] < target || target < nums[0]) {
			return -1;
		} else if (nums[nums.length - 1] == target) {
			return nums.length - 1;
		}
		int start = 0;
		int end = nums.length - 1;

		return erfencha(nums, target, start, end);
	}

	private static int erfencha(int[] nums, int target, int start, int end) {
		int mid = (start + end ) / 2;
		int result = -1;
		if(nums[mid] == target ){
			if(target < nums[mid+1]){
				return mid;
			}else {
				result = erfencha(nums, target, mid+1, end);
//				int i = 0;
//				while(nums[mid+i] == target){
//					i++;
////					System.out.println(i);
//				}
//				return mid+i-1;
			}
		} 
		if (start < end && nums[mid] < target) {
			result = erfencha(nums, target, mid + 1, end);
		}else if(start < end && nums[mid] > target ){
			result = erfencha(nums, target, start, mid-1);
		}
		return result;
	}

	public static void main(String[] args) {
//		int target = 5;
//		int target = 2;
//		int target = 3;
//		int[] nums = new int[] { 1, 2, 2, 2,2,3,4, 5, 5 };

		int target = 5;
		int[] nums = new int[] {1,2,4,5,5,6,6,6};
		
		int index = lastPosition(nums, target);
		System.out.println(index);
	}
}
