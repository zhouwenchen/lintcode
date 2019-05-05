package com.lintcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**  
 * 138. 子数组之和
中文English
给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置

样例
样例 1:
	输入: [-3, 1, 2, -3, 4]
	输出: [0,2] 或 [1,3]
	
	样例解释：
	返回任意一段和为0的区间即可。

样例 2:
	输入: [-3, 1, -4, 2, -3, 4]
	输出: [1,5]

注意事项
至少有一个子数组的和为 0
 * @author zhouwenchen@021.com  
 * @date 2019年4月29日 下午7:25:31 
 */
public class SubarraySum {
	
    /**
     * @param nums
     * @return
     */
	public static List<Integer> subarraySum(int[] nums) {
		List<Integer> ans  = new ArrayList<>();
		int len = nums.length;
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0, -1);
		
		int sum = 0;
		for(int i = 0;i < len;i++){
			sum +=nums[i];
			
			if(map.containsKey(sum)){
				ans.add(map.get(sum) +1);
				ans.add(i);
				return ans;
			}
			map.put(sum,i);
		}
		return ans;
	}
    
    public static void main(String[] args) {
//    	int[] nums = new int[]{-3, 1, 2, -3, 4};
    	int[] nums = new int[]{1,0,1};
    	List<Integer> sum = subarraySum(nums);
    	for (Integer integer : sum) {
			System.out.println(integer);
		}
	}
}
