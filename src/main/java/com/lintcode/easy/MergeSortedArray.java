package com.lintcode.easy;

/**  
 * 6. 合并排序数组 II
中文English
合并两个有序升序的整数数组A和B变成一个新的数组。新数组也要有序。

样例
样例  1:
	输入: A=[1], B=[1]
	输出:[1,1]
	
	样例解释: 
	返回合并后的数组。

样例 2:
	输入: A=[1,2,3,4], B=[2,4,5,6]
	输出: [1,2,2,3,4,4,5,6]
	
	样例解释: 
	返回合并后的数组。

挑战
你能否优化你的算法，如果其中一个数组很大而另一个数组很小？
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class MergeSortedArray {
	
	
	public int[] mergeSortedArray(int[] A, int[] B) {
		int alen = A.length;
		int blen = B.length;
		int[] C = new int[alen + blen];
//		
//		if(A[0]> B[blen]){
//			System.arraycopy(B, 0, C, 0, blen);
//			System.arraycopy(A, 0, C, blen, alen);
//		} else if (B[0] > A[alen]) {
//			System.arraycopy(A, 0, C, 0, alen);
//			System.arraycopy(B, 0, C, alen, blen);
//		}
		
		System.arraycopy(A, 0, C, 0, alen);
		mergeSortedArraytemp(C,alen,B,blen);
		
		return C;
	}
	

	private void mergeSortedArraytemp(int[] A, int m, int[] B, int n) {
		int k  = m+n -1;
		m--;
		n--;
		while(k>=0){
			if(n<0 || (m>=0 && A[m] >=B[n])){
				A[k--] = A[m--];
			} else {
				A[k--] = B[n--];
			}
		}
	}


	public static void main(String[] args) {
		MergeSortedArray mergeSortedArray = new MergeSortedArray();
//		int[] A = {1,2,3};
//		int[] B = {4,5};
		int[] A = {7};
		int[] B = {5,7};
		int[] C = mergeSortedArray.mergeSortedArray(A, B);
		for (int i : C) {
			System.out.println(i);
		}
	}
}
