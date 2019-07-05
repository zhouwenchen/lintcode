package com.offer.test;

/**  
 * 二叉树搜索的后序遍历序列 
 * @author zhouwenchen@021.com  
 * @date 2019年6月21日 下午7:16:03 
 */
public class AfterCheck {
	
	public static boolean afterCheck(int arr[], int length) {
		if (arr == null || length <= 0) {
			return false;
		}
		int end = arr[length - 1]; // 二叉树的根节点
		int i = 0;
		for (; i < length - 1; ++i) {
			if (arr[i] > end) { // 左子树的节点都是小于根节点的
				break;
			}
		}
		// 结束上面的循环，i的值为2
		int j = i;
		for (; j < length - 1; ++j) {
			if (arr[j] < end) { // 大于j的，都是根节点的右子树，故数据都是大于根节点的值
				return false;
			}
		}

		// 循环递归判断左子树是否是二叉搜索树
		boolean left = true;
		if (i > 0) {
			left = afterCheck(arr, i);
		}
		boolean right = true;
		if (i < length - 1) {
			right = afterCheck(arr, length - i - 1);
		}
		return left && right;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] { 12, 7, 6, 9, 11, 10,8 };
		boolean b = afterCheck(arr, arr.length-1);
		System.out.println(b);
	}
}
