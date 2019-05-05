package com.lintcode.easy;

/**
 * 366. 斐波纳契数列 中文English 查找斐波纳契数列中第 N 个数。
 * 
 * 所谓的斐波纳契数列是指：
 * 
 * 前2个数是 0 和 1 。 第 i 个数是第 i-1 个数和第i-2 个数的和。 斐波纳契数列的前10个数字是：
 * 
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 */
public class Fibonacci {

	public static void main(String[] args) {
		// int i = fibonacci(10);
		int i = fibonacci(40);

		System.out.println(i);
	}

	/**
	 * 使用递归，内存会溢出的
	 */
	/*public static int fibonacci(int n) {
		int[] a = new int[n];
		if (n == 1) {
			return a[0] = 0;
		} else if (n == 2) {
			return a[1] = 1;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}*/
	
	/**
	 * 使用数组实现
	 * @param n
	 * @return
	 */
/*	public static int fibonacci(int n) {
		int[] a = new int[100];
		a[0] = 0;
		a[1] = 1;
		for(int i = 2; i < a.length;i++){
			a[i] = a[i-1] + a[i-2];
		}
		return a[n-1];
	}*/
	
	
	public static int fibonacci(int n) {
		if(n == 1){
			return 0;
		}else if(n == 2){
			return 1;
		}
		
		int a = 0;
		int b = 1;
		int result = 0;
		for(int i = 3;i<=n;i++){
			result = a+b;
			a = b;
			b = result;
		}
		return result;
	}
}
