package com.offer.test;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * 样例  1:
	输入: A=[1], B=[1]
	输出:[1,1]
	
	样例解释: 
	返回合并后的数组。

样例 2:
	输入: A=[1,2,3,4], B=[2,4,5,6]
	输出: [1,2,2,3,4,4,5,6]
	
	样例解释: 
	返回合并后的数组。


 * @author zhouwenchen@021.com  
 * @date 2019年6月13日 上午9:44:09 
 */
public class SortArr {
	public static void sortArr(int[] A, int[] B) {
		// 将数组A拷贝到数组C中，数组C的长度是等于A.length+B.length
		int[] C = new int[A.length + B.length];

		// 1.解决问题1.可能某一个数组的最大值小于另个数组的最小值
		int a = A.length - 1;
		int b = B.length - 1;
		/**
		 * 可能某一个数组为空
		 */
		if (A.length == 0) {
			System.arraycopy(B, 0, C, 0, b + 1);
			return;
		}
		if (B.length == 0) {
			System.arraycopy(A, 0, C, 0, a + 1);
			return;
		}
		if (A[a] < B[0]) {
			System.arraycopy(A, 0, C, 0, a + 1);
			System.arraycopy(B, 0, C, a + 1, b + 1);
			return;
		}
		if (B[b] < A[0]) {
			System.arraycopy(B, 0, C, 0, b + 1);
			System.arraycopy(A, 0, C, b + 1, a + 1);
			return;
		}

		// 从数组的高位置开始判断
		for (int i = C.length - 1; i >= 0; i--) {
			// A数组已经判断完了，直接将剩下的B数组复制到C中
			if (a < 0) {
				System.arraycopy(B, 0, C, 0, b + 1);
				continue;
			}
			// B数组已经判断完了，直接将剩下的A数组复制到C中
			if (b < 0) {
				System.arraycopy(A, 0, C, 0, a + 1);
				continue;
			}
			if (A[a] >= B[b]) {
				C[i] = A[a];
				a--;
			} else {
				C[i] = B[b];
				b--;
			}
		}
		System.out.println(C.toString());
	}

	/**
	 * 将两个有序的数组添加到更大的数组中，然后直接使用Collections.sort()
	 * @param A
	 * @param B
	 */
	public static void sortArr1(int[] A, int[] B) {
		int[] C = new int[A.length + B.length];
		System.arraycopy(A,0,C,0,A.length);
		System.arraycopy(B,0,C,A.length,B.length);
		Arrays.sort(C);
	}

	/**
	 * 创建一个大数组，从数组末尾开始填充数据,
	 * @param A
	 * @param B
	 */
	public static void sortArr2(int[] A, int[] B) {
		int alen = A.length - 1;
		int blen = B.length - 1;
		int[] C = new int[A.length + B.length];
		int clen = C.length - 1;
		while (alen >= 0 && blen >= 0) {
			if (A[alen] > B[blen]) {
				C[clen--] = A[alen--];
			} else {
				C[clen--] = B[blen--];
			}
		}
		// 判断 A 或者 B已经没有数据了
		if (alen >= 0) {
			System.arraycopy(A, 0, C, 0, alen - blen);
		}
		if (blen >= 0) {
			System.arraycopy(B, 0, C, 0, blen - alen);
		}
		System.out.println(C);
	}
	
	/**
	 * 问题1，可能某一个数组的最大值小于两个数组的最小值。
	 * @param args
	 */
	public static void main(String[] args) {
		// 测试案例1：
//		int[] A = new int[] { 1, 2, 3, 4};
//		int[] B = new int[] { 2, 4, 5, 6 };
		
		// 测试案例2
//		int[] A = new int[] { 1, 2, 3, 4};
//		int[] B = new int[] { 5, 6, 7, 8 };
		
		// 测试案例3
//		int[] A = new int[] { };
//		int[] B = new int[] { 5, 6, 7, 8 };

 		int[] A = new int[] { 1,3,5};
		int[] B = new int[] { 2, 4, 6, 8 };
		sortArr2(A, B);
	}
}
