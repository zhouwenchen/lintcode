package com.offer.test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**  
 * 最小的k个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * @author zhouwenchen@021.com  
 * @date 2019年6月25日 上午11:37:13 
 */
public class GetLeastNumbers {

	public static List<Integer> getLeastNumbers(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		List<Integer> resultList = new ArrayList<Integer>();
		// 如果k的值大于等于nums的长度的话，直接返回
		if (nums.length <= k) {
			for (int num : nums) {
				resultList.add(num);
			}
			return resultList;
		}

		// k的值小于nums的长度
		PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> {
			return o2.compareTo(o1);
		});
		for (int num : nums) {
			if (queue.size() < k) {
				queue.add(num);
			} else if (queue.peek() > num) {
				queue.poll();
				queue.add(num);
			}
		}
		while (!queue.isEmpty()) {
			resultList.add(queue.poll());
		}
		return resultList;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 5, 1, 6, 2, 7, 3, 8, 0, 9, 10, 11, 12 };
		List<Integer> lists = getLeastNumbers(nums, 4);
		for (Integer integer : lists) {
			System.out.println(integer);
		}
	}
}
