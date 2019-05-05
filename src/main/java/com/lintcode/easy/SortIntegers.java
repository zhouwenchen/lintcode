package com.lintcode.easy;

/**
 * 给一组整数，按照升序排序，使用选择排序，冒泡排序，插入排序或者任何 O(n2) 的排序算法。
 * 输入:  [3, 2, 1, 4, 5]
 * 输出:  [1, 2, 3, 4, 5]
 */
public class SortIntegers {
	public static void main(String[] args) {
		int[] A = {3, 2, 1, 4, 5};
//		int[] A = {3, 2, 1};
		sortIntegers(A);
		for (int i : A) {
			System.out.print(i+"\t");
		}
	}
	
	/**
	 * 使用双层的for循环实现
	 * 冒泡排序
	 * @param A
	 */
/*	public static void sortIntegers(int[] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				if(A[i]>A[j]){
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
		}
	}*/
	
	/**
	 * 选择排序
	 * @param A
	 */
/*	public static void sortIntegers(int[] A) {
		for(int i = 0; i < A.length - 1; i++){
			int k = i;
			// 查询最小的记录的数组下标
			for(int j = k; j<A.length;j++){
				if(A[j] < A[k]){
					k = j;
				}
			}
			// 内存循环结束
			if(i != k){
				int temp = A[i];
				A[i] = A[k];
				A[k] = temp;
			}
		}
	}*/
	
	/**
	 * 插入排序
	 * @param A
	 */
/*	public static void sortIntegers(int[] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j > 0; j--) {
				if (A[j] < A[j - 1]) {
					int temp = A[j];
					A[j] = A[j - 1];
					A[j - 1] = temp;
				}
			}
		}
	}*/
	
	
	/**
	 * 希尔排序
	 * @param A
	 */
/*	public static void sortIntegers(int[] A) {
		// 增量
		int gap = A.length / 2;
		while (gap > 0) {
			for (int j = gap; j < A.length; j++) {
				int i = j;
				// 进行插入排序
				while (i >= gap && A[i - gap] > A[i]) {
					int temp = A[i - gap] + A[i];
					A[i - gap] = temp - A[i - gap];
					A[i] = temp - A[i - gap];
					i -= gap;
				}
			}
			// 重新计算增量
			gap = gap / 2;
		}
	}*/
	
	/**
	 * 归并排序
	 * @param A
	 */
	public static void sortIntegers(int[] A) {
		sortMerge(A, 0, A.length - 1);
	}

	public static void sortMerge(int[] nums, int left, int right) {
		if (left == right)
			return; // 当待排序的序列长度为1时，递归开始回溯，进行merge
		int middle = left + (right - left) / 2;
		sortMerge(nums, left, middle);
		sortMerge(nums, middle + 1, right);
		mergeArr(nums, left, middle, right);
	}

	public static void mergeArr(int[] nums, int left, int middle, int right) {
		int[] tem = new int[right - left + 1];
		int i = left, j = middle + 1, k = 0;
		while (i <= middle && j <= right) {
			tem[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
		}
		while (i <= middle) {
			tem[k++] = nums[i++];
		}
		while (j <= right) {
			tem[k++] = nums[j++];
		}
		// 将辅助数组数据写入原数组
		int index = 0;
		while (left <= right) {
			nums[left++] = tem[index++];
		}
	}

}
