package com.offer.test;

import java.util.Arrays;

/**  
 * 扑克牌中的顺子
 * @author zhouwenchen@021.com  
 * @date 2019年7月19日 下午8:19:18 
 */
public class IsContinuous {
	public static boolean isContinuous(int[] nums) {
		if(nums == null || nums.length < 5){
			return false;
		}
		
		// 先排序
		Arrays.sort(nums);
		int cnt = 0;
		for(int num: nums){
			// 统计0的个数
			if(num == 0){
				cnt++;
			}
		}
		int ksum = 0;
		for(int i = 0; i< nums.length -1;i++){
			int a = nums[i];
			int b = nums[i+1];
			if(a==0 || b== 0){
				continue;
			}
			if(b == a){
				return false;
			}
			ksum += b -a -1;
		}
		if((cnt !=0	&& ksum == cnt) || ksum == 0){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,6};
		boolean b = isContinuous(nums);
		System.out.println(b);
	}
}
