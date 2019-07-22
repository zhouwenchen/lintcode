package com.offer.test;

import java.util.ArrayList;

/**  
 * 和为S的连续正数序列
 * 
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月18日 下午4:20:11 
 */
public class FindContinueousSequences {
	
	public static ArrayList<ArrayList<Integer>> findContinueousSequences(int sum) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
		if (sum < 2) {
			return arrayList;
		}
		int start = 1;
		int end = 2;
		while (start != (sum + 1) >> 1) {
			int currentSum = sumOfList(start, end);
			if (currentSum == sum) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = start; i <= end; i++) {
					list.add(i);
				}
				arrayList.add(list);
				start++;
				end++;
			} else if (currentSum < sum) {
				end++;
			} else {
				start++;
			}
		}
		return arrayList;
	}
	
	private static int sumOfList(int start, int end) {
		int sum = start;
		for (int i = start + 1; i <= end; i++) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arrayLists = findContinueousSequences(9);
		for (ArrayList<Integer> list : arrayLists) {
			System.out.println(list);
		}
	}
}
