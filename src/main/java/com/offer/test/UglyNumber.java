package com.offer.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**  
 * 　把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 * @author zhouwenchen@021.com  
 * @date 2019年7月15日 下午7:55:53 
 */
public class UglyNumber {

	public static int uglyNumber(int num) {
		if (num <= 0) {
			return 0;
		}
		// 1. 存放丑数
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		while (list.size() < num) {
			int num2 = list.get(i2) * 2;
			int num3 = list.get(i3) * 3;
			int num5 = list.get(i5) * 5;

			// 获取最小值
			int min = Math.min(num2, Math.min(num3, num5));
			list.add(min);

			// 保证最小的数不重复
			if (min == num2) {
				i2++;
			}
			if (min == num3) {
				i3++;
			}
			if (min == num5) {
				i5++;
			}
		}

		// 返回第N个丑数
		return list.get(list.size() - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// 输入数据
			int index = sc.nextInt();
			int result = uglyNumber(index);

			System.out.println(result);
		}
		sc.close();
	}
}
