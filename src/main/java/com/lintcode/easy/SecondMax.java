package com.lintcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**  
 * 479. 数组第二大数
在数组中找到第二大的数

样例
例1：

输入：[1,3,2,4]，
输出：3。
例2：

输入：[1,2]，
输出：1。
注意事项
你可以假定至少有两个数字
 * @author zhouwenchen@021.com  
 * @date 2019年6月3日 下午8:29:54 
 */
public class SecondMax {
	public static int secondMax(int[] nums) {
		// 1.先排序，之后查找第二个值
		List<Integer> list = new ArrayList<>(nums.length);
		for (int num : nums) {
			list.add(num);
		}
		Collections.sort(list);
		return list.get(list.size() - 2);
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 0 };
		int secondMax = secondMax(nums);
		System.out.println(secondMax);
	}
}
