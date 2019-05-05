package com.lintcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**  
 * 
 * 80. 中位数
中文English
给定一个未排序的整数数组，找到其中位数。

中位数是排序后数组的中间值，如果数组的个数是偶数个，则返回排序后数组的第N/2个数。

样例
Example 1:

Input：[4, 5, 1, 2, 3]
Output：3
Explanation:
经过排序，得到数组[1,2,3,4,5]，中间数字为3
Example 2:

Input：[7, 9, 4, 5]
Output：5
Explanation:
经过排序，得到数组[4,5,7,9]，第二个(4/2)数字为5
挑战
时间复杂度为O(n)

注意事项
数组大小不超过10000
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class Median {
	public static int median(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int length = nums.length;
		Integer[] numsIn = new Integer[length];
//		List<Integer> list = Arrays.stream( nums ).boxed().collect(Collectors.toList());
		
		for(int i = 0; i < length;i++){
			numsIn[i] = new Integer(nums[i]);
		}
		
		List<Integer> list = Arrays.asList(numsIn);
		Collections.sort(list,new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		if(length%2 != 0){
			return list.get(length/2);
		} 
		
		return list.get(length/2-1);
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 1, 2, 3 };
//		int[] nums = { 7, 9, 4, 5 };
//		int[] nums = {  };
		int median = median(nums);
		System.out.println(median);
	}
}
