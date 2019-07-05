package com.offer.test;

import java.util.Scanner;

/**  
 * 斐波那契数列的实现
 * 1、1、2、3、5、8、13、21、34
 * @author zhouwenchen@021.com  
 * @date 2019年6月14日 上午9:45:13 
 */
public class FibonacciDemo01 {
	
	/**
	 * 1 使用递归实现的逻辑
	 * 效率很低
	 */
	public static int fibonacci1(int n) {
		if (n == 0){
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci1(n - 1) + fibonacci1(n - 2);
	}
	
	// halfMax 表示的是Integer的最大值的一半，保证两个小于halfMax的值相加不会越界
	private static int halfMax = Integer.MAX_VALUE >> 1;
	/**
	 * 2.还是使用的是递归的方式
	 */
	public static int fibonacci2(int n, int m) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}

		if (m < halfMax) {
			int result = fibonacci2(n - 1, m) + fibonacci2(n - 2, m);
			// return result % m
			// 本来应该的是求余操作，由于result不会大于2m，这里用减法速度会更快
			return result >= m ? result - m : result;
		} else {
			long result = (long) (fibonacci2(n - 1, m) + fibonacci2(n - 2, m));
			return (int) (result >= m ? result - m : result);
		}
	}
	
	// 保存求解中的值
	private static int[] value;
	// value中的值是否被计算过
	private static boolean[] used;
	
	/**
	 * 使用数组，记录重复的数字
	 * 对斐波那契数列第n项求值，结果对m求余
	 */
	public static int getFibonacci(int n, int m) {
		if (used[n]) {
			return value[n];
		}
		if (m < halfMax) {
			int result = getFibonacci(n - 1, m) + getFibonacci(n - 2, m);
			result = result >= m ? result - m : result;
			value[n] = result;
			used[n] = true;
			return result;
		} else {
			long result = getFibonacci(n - 1, m) + getFibonacci(n - 2, m);
			value[n] = (int) result;
			used[n] = true;
			return value[n];
		}
	}
	
	public static int fibonacci3(int n,int m){
		if(n<1){
			return 0;
		}
		if(n==1 || n==2){
			return 1;
		}
		value = new int[n+1];
		value[0] = 0;
		value[1] = 1;
		value[2] = 1;
		used = new boolean[n+1];
		used[0] = true;
		used[1] = true;
		used[2] = true;
		return getFibonacci(n, m);
	}
	
	
	/**
	 * 4.从前往后计算
	 * 使用for循环，很提高效率的
	 */
	public static int fibonacci4(int n, int m) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int value[] = new int[n + 1];
		value[1] = 1;
		value[2] = 1;

		// 后一项等于前两项的和
		for (int i = 3; i <= n; i++) {
			long result = (long) value[i - 1] + value[i - 2];
			value[i] = (int) (result >= m ? result - m : result);
		}
		return value[n];
	}
	
	/**
	 * 将值添加到循环的队列中，减少了空间的使用
	 */
	public static int fibonacci5(int n, int m) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		// 循环队列用来存放结果，这里使用的是4，而不是3，为了计算的方便
		int[] value = new int[4];
		value[1] = 1;
		value[2] = 1;

		// 后一项等于前两项的和
		for (int i = 3; i <= n; i++) {
			long result = value[(i - 1) & 3] + value[(i - 2) & 3];
			value[i & 3] = (int) (result > m ? result - m : result);
		}
		return value[n & 3];
	}
	
	
	
	public static void main(String[] args) {
		// 1.使用递归实现的算法（效率太低了）
//		System.out.println(fibonacci1(33)); 	// fibonacci1(33)=3524578

		// 2.还是使用的是递归的方式实现
//		while(true){
//			Scanner scanner = new Scanner(System.in);
//			int n = scanner.nextInt();
//			System.out.println(FibonacciDemo01.fibonacci4(n, 19999997)); 	//fibonacci2(33)=3524578
//		}
		
		// 3.还是使用的是递归的方式实现,但是记录了一些重复的元素，不需要重复去计算这个值
		while(true){
			Scanner scanner = new Scanner(System.in);
			int n = scanner.nextInt();
			System.out.println(FibonacciDemo01.fibonacci5(n, 19999997));
		}
		
		
	}
}
