package com.offer.test;

/**  
 * 1+2+3+...+n不能用while、for、if else等实现
 * 求 1+2+ … +n ，要求不能使用乘除法、 for 、 while 、 if 、 else 、 switch 、 case 等关键字以及条件判断语句
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月22日 上午11:05:46 
 */
public class GetSum {
	
	
	/**
	 * 使用递归的函数
	 * @param n
	 * @return
	 */
	public static int getSum(int n) {
		int result = n;
		boolean b = (n > 0) && ((result += getSum(n-1)) >0 );
		return result;
	}
	
	/**
	 * 使用库函数
	 * @param n
	 * @return
	 */
	public static int getSum2(int n) {
		int result = (int)(Math.pow(n, 2)+n);
		return result >> 1;
	}
	
	public static void main(String[] args) {
		int sum = getSum2(5);
		System.out.println(sum);
	}
}