package com.example.demo;

import java.util.Scanner;

/**  
 * 求某一个数，两质数之积
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class TestzhiShu {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("输入一个数：");
		long number = in.nextLong();
		System.out.print(number + "=");
		int i = 1;
		while (i < number) {
			if (number % i == 0 && i == 1) {
				System.out.print(i + "x");
				number /= i;

			} else if (number % i == 0 && i != 1) {
				System.out.print(i + "x");
				number /= i;
				continue;
			}
			i++;
		}
		System.out.print(i);
	}
}