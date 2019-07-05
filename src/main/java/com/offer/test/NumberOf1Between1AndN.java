package com.offer.test;

/**  
 * 从1到n整数中1出现的次数
 * 
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1的数字有1， 10, 11和12；1一共出现了5次。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月25日 下午4:24:47 
 */
public class NumberOf1Between1AndN {

	/**
	 * 这种效率很低，故此这种方案不推荐使用的
	 * @param n
	 * @return
	 */
	public static int numberOf1Between1AndN(int n) {
		int result = 0;
		if (n < 0) {
			return result;
		}
		for (int i = 1; i <= n; i++) {
			result += numberOf1(i);
		}
		return result;
	}

	/**
	 * 计算每一个整数中包含的1的个数
	 * @param i
	 * @return
	 */
	private static int numberOf1(int i) {
		int count = 0;
		while (i > 0) {
			int ge = i % 10;
			if (ge == 1) {
				count++;
			}
			i /= 10;
		}
		return count;
	}
	
	public static int numberOf1Between1AndN2(int n, int x) {
		if (n < 0 || x < 1 || x > 9) {
			return 0;
		}
		int cur, low, temp, high = n, i = 1, total = 0;
		while (high != 0) {
			high = n / (int) Math.pow(10, i); // 获取高位的值
			temp = n % (int) Math.pow(10, i);// 获取低位的值
			cur = temp / (int) Math.pow(10, i - 1);
			low = temp % (int) Math.pow(10, i - 1);

			if (cur == x) {
				total += high * Math.pow(10, i - 1) + low + 1;
			} else if (cur < x) {
				total += high * (int) Math.pow(10, i - 1);
			} else {
				total += (high + 1) * (int) Math.pow(10, i - 1);
			}
			i++;
		}
		return total;
	}
	
	public static void main(String[] args) {

		// 1 使用循环的方式
		System.out.println(numberOf1Between1AndN(21354));

		// 2 使用更为优秀的方案
		System.out.println(numberOf1Between1AndN2(21354, 1));
	}
}
