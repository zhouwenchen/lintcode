package com.offer.test;

/**  
 * 数值的整次方根
 * 边界的测试条件：
 * 	指数是0，
 *  指数是1，
 *  指数大于1
 *  指数小于0
 *
 * @author zhouwenchen@021.com  
 * @date 2019年6月18日 上午11:19:17 
 */
public class PowerDemo {

	/**
	 * 数值的整次方根
	 * @param base 基数
	 * @param exp 指数
	 * @return
	 */
	public static double power(double base, int exp) {
		if (exp == 0) {
			return 1;// 假定0的0次方根为1
		}
		if (exp == 1) {
			return base;
		}
		if (exp > 1) {
			double result = power(base, exp >> 1);
			result *= result;
			// 判断是偶数，还是奇数的问题
			if ((exp & 1) == 1) {// 表示的是奇数
				result *= base;
			}
			return result;
		}
		if (exp < 0) {
			exp = -exp;
			double result = power(base, exp);
			return 1 / result;
		}
		return -1;
	}

	public static void main(String[] args) {
		double base = 2.5;
		int exp = -4;
		double d = power(base, exp);
		System.out.println(d);
		double pow = Math.pow(base, exp);
		System.out.println(pow);
	}
}
