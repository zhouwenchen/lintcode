package com.lintcode.easy;

/**  
 * 64. 合并排序数组
合并两个排序的整数数组A和B变成一个新的数组。

样例
Example 1:

Input：[1, 2, 3]  3  [4,5]  2
Output：[1,2,3,4,5]
解释:
经过合并新的数组为[1,2,3,4,5]
Example 2:

Input：[1,2,5] 3 [3,4] 2
Output：[1,2,3,4,5]
Explanation:
经过合并新的数组为[1,2,3,4,5]
注意事项
你可以假设A具有足够的空间（A数组的大小大于或等于m+n）去添加B中的元素。
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class MergeSortedArray2 {
	
	public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
		int i = m -1;
		int j = n -1;
		int index = m + n -1;
		while(i >= 0 && j >= 0){
			if(A[i] > B[j]){
				A[index--] = A[i--];
			} else {
				A[index--] = B[j--];
			}
		}
		
		while(i>=0){
			A[index--] = A[i--];
		}
		while(j>=0){
			A[index--] = B[j--];
		}
	}
    
    public static void main(String[] args) {
    	int[] A = new int[5];
    	A[0] =1;
    	A[1] =2;
    	A[2] =3;
    	int[] B = new int[]{4,5};
    	mergeSortedArray(A, 3, B, 2);
	}
}
