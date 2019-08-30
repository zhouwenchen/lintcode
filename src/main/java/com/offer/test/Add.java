package com.offer.test;

/**  
 * 不使用加减乘除法做运算
 * 比如说5+17=22；
 * 使用位运算即可以得到
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月22日 上午11:26:57 
 */
public class Add {
	
	public static int add(int m, int n) {
		while (n != 0) {
			int temp = m ^ n;
			n = (m & n) << 1;
			m = temp;
		}
		return m;
	}

	public static void main(String[] args) {
		int sum = add(5, 17);
		System.out.println(sum);
	}
}