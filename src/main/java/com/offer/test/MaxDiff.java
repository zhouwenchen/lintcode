package com.offer.test;

/**  
 * 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,7, 12, 16, 14}。
 * 如果我们能在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月22日 上午10:43:17 
 */
public class MaxDiff {
	
	public static int maxDiff(int[] nums) {
		// 参数的合法性判断
		if(nums == null || nums.length <= 0){
			return -1;
		}
		
		int min = nums[0];
		int maxDiff = nums[1] - min;
		for(int i = 2; i < nums.length;i++){
			if(nums[i-1] < min){
				min = nums[i-1];
			}
			int curDiff = nums[i] - min;
			if(curDiff > maxDiff){
				maxDiff = curDiff;
			}
		}
		
		return maxDiff;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 9, 11, 8, 5, 7, 12, 16, 14 };
		int diff = maxDiff(nums);
		System.out.println(diff);
	}
}
