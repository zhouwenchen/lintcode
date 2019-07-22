package com.offer.test;

/**  
 * 
 * 构建乘积数组（思路与实现）
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月22日 下午2:04:36 
 */
public class Multiply {
	public static int[] multiply(int[] A) {
		/*
		 * 这道题的中心思想是将返回的数据列成一个矩阵，每一个矩阵的行向量都是一个从a(0)到a(n-1)
		 * 然后这个对角线都是1.那么此时B0的值就是A0为一，剩下的行向量相乘。
		 */
		int length = A.length;
		int[] B = new int[length];
		B[0] = 1;
		for (int i = 1; i < length; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		int temp = 1;
		for (int j = length - 2; j >= 0; j--) {
			temp *= A[j + 1];// temp始终会记录值，每次只需要加上这行上三角没有乘进来的数就可以了。
			B[j] *= temp;
		}
		return B;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] B = multiply(A);
		for (int i : B) {
			System.out.print(i + "\t");
		}
	}
}
