package com.lintcode.easy;

/**  
 * 100. 删除排序数组中的重复数字
Given a sorted array, 'remove' the duplicates in place such that each element appear only once and return the 'new' length.

Do not allocate extra space for another array, you must do this in place with constant memory.

样例
Example 1:
	Input:  []
	Output: 0


Example 2:
	Input:  [1,1,2]
	Output: 2
	
	Explanation:  
	uniqued array: [1,2]

 * @author zhouwenchen@021.com  
 * @date 2019年4月17日 下午7:30:05 
 */
public class RemoveDuplicates {
	
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int size = 0;
		for(int i = 0;i < nums.length;i++){
			if(nums[i] != nums[size]){
				nums[++size] = nums[i];
			}
		}
		return size + 1;
	}
    
    public static void main(String[] args) {
//    	int[] nums = new int[]{1,1,2};
    	int[] nums = new int[]{1,1,2,2,2,4};
    	int len = removeDuplicates(nums);
    	System.out.println(len);
	}
}
