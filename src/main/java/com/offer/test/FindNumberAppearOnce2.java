package com.offer.test;

/**  
 * 数组中唯一只出现一次的数字
 * 在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月18日 下午2:32:43 
 */
public class FindNumberAppearOnce2 {
	public static int findNumberAppearOnce2(int[] nums) {
		if(nums == null || nums.length == 0){
			throw new RuntimeException();
		}
		
		// 
		int[] bitSum = new int[32];
		for(int i = 0; i < nums.length; i++){
			int bitMask = 1;
			for (int j = 31; j >= 0; j--) {
				int bit = nums[i] & bitMask; // 注意arr[i]&bitMask不一定等于1或者0，有可能等于00010000
				if (bit != 0) {
					bitSum[j] += 1;
				}
				bitMask = bitMask << 1;
			}
		}
		int result = 0;
		for(int i = 0; i < 32; i++){
			result = result <<1;
			result +=(bitSum[i] % 3);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,2,2,2,3,3,3,4};
		int num = findNumberAppearOnce2(nums);
		System.out.println(num);
	}
}
