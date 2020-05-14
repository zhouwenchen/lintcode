package com.lintcode.easy;

import java.util.*;

/**  
 * 46. 主元素
给定一个整型数组，找出主元素，它在数组中的出现次数严格大于数组元素个数的二分之一。

样例
样例 1:

输入: [1, 1, 1, 1, 2, 2, 2]
输出: 1
样例 2:

输入: [1, 1, 1, 2, 2, 2, 2]
输出: 2
挑战
要求时间复杂度为O(n)，空间复杂度为O(1)

注意事项
你可以假设数组非空，且数组中总是存在主元素。
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class MajorityNumber {
    
	public static int majorityNumber(List<Integer> nums) {
		if(nums.size()==0)return 0;
		Iterator<Integer> it = nums.iterator();
		Map<Integer,Integer> map = new HashMap<>();
		while(it.hasNext()){
			Integer value = it.next();
			if(map.containsKey(value)){
				map.put(value, map.get(value)+1);
			}else{
				map.put(value, 1);
			}
		}
		
		int size = nums.size()/2;
		for(Integer in : map.keySet()){
			Integer count = map.get(in);
			if(count>size){
				return in;
			}
		}
		return -1;
	}
	
	public static int majorityNumber1(List<Integer> nums) {
		if (nums.size() == 0)
			return 0;
		Iterator<Integer> it = nums.iterator();
		Map<Integer, Integer> map = new HashMap<>();
		int size = nums.size() / 2;
		while (it.hasNext()) {
			Integer value = it.next();

			// 先判断这个value的数量是否超过半数
			if (!map.isEmpty() && map.get(value) != null && map.get(value) > size) {
				return value;
			}
			if (map.containsKey(value)) {
				map.put(value, map.get(value) + 1);
			} else {
				map.put(value, 1);
			}
		}

		for (Integer in : map.keySet()) {
			Integer count = map.get(in);
			if (count > size) {
				return in;
			}
		}
		return 0;
	}
	
	public static int majorityNumber2(List<Integer> nums) {
		int currentMajor = 0;
		int count = 0;
		for (Integer num : nums) {
			if(count == 0){
				currentMajor = num;
			}
			if(num == currentMajor){
				count++;
			} else {
				count--;
			}
		}
		return currentMajor;
	}

	/**
	 * 排序，取中位数
	 * @param nums
	 * @return
	 */
	public static int majorityNumber3(List<Integer> nums) {
		Collections.sort(nums);
		return nums.get(nums.size()/2);
	}
	
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(1);
		nums.add(1);
		nums.add(1);
		nums.add(2);
		nums.add(2);
		nums.add(2);
//		int value = majorityNumber(nums);
//		int value = majorityNumber1(nums);
//		int value = majorityNumber2(nums);
		int value = majorityNumber3(nums);
		System.out.println(value);
	}
}