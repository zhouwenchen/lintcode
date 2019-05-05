package com.lintcode.easy;

/**  
 * 
 * 56. 两数之和
给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。

你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。

样例
Example1:
numbers=[2, 7, 11, 15], target=9
return [0, 1]
Example2:
numbers=[15, 2, 7, 11], target=9
return [1, 2]
挑战
Either of the following solutions are acceptable:

O(n) Space, O(nlogn) Time
O(n) Space, O(n) Time
注意事项
你可以假设只有一组答案。
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class TwoSum {
	
	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

    public static void main(String[] args) {
//    	int[] numbers = new int[]{15, 2, 7, 11};
//    	int target = 9;
    	int[] numbers = new int[]{1,0,-1};
    	int target = 0;
    	int[] sum = twoSum(numbers, target);
    	for (int i : sum) {
			System.out.print(i+"\t");
		}
	}
}
