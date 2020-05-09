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
	 * TODO 问题1.由于使用递归，会导致 StackOverflowError 溢出的
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

	/**
	 *
	 * @param base 基数
	 * @param exp 指数
	 * @return
	 */
	public static double Mypow(double base, int exp) {
		double ans = 1;
		for(int m = exp; m!=0;m /= 2, base *=base){
			if((m&1)==1){ // 奇数
				ans *= base;
			}
		}
		return exp < 0 ? 1 / ans:ans;
	}

	public static void main(String[] args) {
		double base = 2.0000;
		int exp = 7;
		double d = Mypow(base, exp);
		System.out.println(d);
		double pow = Math.pow(base, exp);
		System.out.println(pow);
	}
}
