package com.lintcode.easy;

/**  
 * 
 * 60. 搜索插入位置
给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。

你可以假设在数组中无重复元素。

样例
[1,3,5,6]，5 → 2

[1,3,5,6]，2 → 1

[1,3,5,6]， 7 → 4

[1,3,5,6]，0 → 0

挑战
时间复杂度为O(log(n))
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class SearchInsert {
	
	public static int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		int start = 0;
		int end = A.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(A[mid] == target){
				return mid;
			} else if(A[mid] < target){
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if(A[start] >= target){
			return start;
		} else if(A[end] >= target){
			return end;
		} else {
			return end + 1;
		}
	}
    
	public static void main(String[] args) {
//		int[] A = new int[] { 1, 3, 5, 6 };
//		int target = 5;
//		int[] A = new int[] { 1,3,5,6};
//		int target = 2;
//		int target = 7;
//		int target = 0;
		
		int[] A = new int[] { -1,0,1,2};
		int target = 2;
		
		int pos = searchInsert(A, target);
		System.out.println(pos);
	}
}
