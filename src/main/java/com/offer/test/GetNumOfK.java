package com.offer.test;

/**  
 * 数字在排序数组中出现的次数
 * 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月16日 下午8:17:36 
 */
public class GetNumOfK {
	
	public static int getNumOfK(int[] nums,int k) {
		if (nums == null || nums.length <= 0) {
			return -1;
		}
		int first = getFirstNumOfk(nums,0,nums.length-1,k);
		int last = getLastNumOfk(nums,0,nums.length-1,k);
		return last - first +1;
	}

	/**
	 * 获取指定数字在指定数组中最后一次出现的位置
	 * @param nums
	 * @param i
	 * @param j
	 * @return
	 */
	private static int getLastNumOfk(int[] nums, int start, int end, int k) {
		int mid = (start + end) >> 1;
		int first = 0;
		if (nums[mid] == k) { // 二分查找，获取到目标的值得位置
			if(mid  == end){
				return mid;
			} else if (mid + 1 <= end && nums[mid + 1] == k) { // 判断之后的数是否也是目标值
				first = getLastNumOfk(nums, mid+1, end, k);
			} else {
				return mid;
			}
		}
		if (nums[mid] > k) {
			first = getLastNumOfk(nums, start , end -1 , k);
		}
		if (nums[mid] < k) {
			first = getLastNumOfk(nums, mid + 1, end , k);
		}
		return first;
	}
	
	/**
	 * 获取指定数字在指定数组中第一次出现的位置
	 * @param nums
	 * @param i
	 * @param j
	 * @return
	 */
	private static int getFirstNumOfk(int[] nums, int start, int end, int k) {
		int mid = (start + end) >> 1;
		int first = 0;
		if (nums[mid] == k) { // 二分查找，获取到目标的值得位置
			if(mid  == 0){
				return mid;
			} else if (mid-1>=0 && nums[mid - 1] == k) { // 判断之前的数是否也是目标值
				first = getFirstNumOfk(nums, start, mid - 1, k);
			} else {
				return mid;
			}
		}
		if (nums[mid] > k) {
			first = getFirstNumOfk(nums, start , end -1 , k);
		}
		if (nums[mid] < k) {
			first = getFirstNumOfk(nums, mid + 1, end , k);
		}
		return first;
	}

	public static void main(String[] args) {
//		int[] nums = new int[] { 1, 2, 3, 3, 3, 3, 4, 5 };
//		int[] nums = new int[] { 3, 3, 3, 3, 3, 3, 4, 5 };
		int[] nums = new int[] { 1, 3, 3, 3, 3, 3, 3, 3 };
		int len = getNumOfK(nums,3);
		System.out.println(len);
	}
}
