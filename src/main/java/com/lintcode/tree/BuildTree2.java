package com.lintcode.tree;

import com.lintcode.node.TreeNode;

/**  
 * 73. 前序遍历和中序遍历树构造二叉树
根据前序遍历和中序遍历树构造二叉树.

样例
样例 1:

输入：[],[]
输出：{}
解释：
二叉树为空
样例 2:

输入：[2,1,3],[1,2,3]
输出：{2,1,3}
解释：
二叉树如下
  2
 / \
1   3
注意事项
你可以假设树中不存在相同数值的节点
 * @author zhouwenchen@021.com  
 * @date 2019年6月10日 下午2:42:59 
 */
public class BuildTree2 {
	
	private static int findPosition(int[] arr, int start, int end, int key) {
		int i;
		for (i = start; i <= end; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

	private static TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend) {
		if (instart > inend) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[prestart]);
		int position = findPosition(inorder, instart, inend, preorder[prestart]);

		root.left = myBuildTree(inorder, instart, position - 1, preorder, prestart + 1, prestart + position - instart);
		root.right = myBuildTree(inorder, position + 1, inend, preorder, position - inend + preend + 1, preend);
		return root;
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder.length != preorder.length) {
			return null;
		}
		return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
	}
	
	public static void main(String[] args) {
//		int[] preorder = new int[] { 2, 1, 3 };
//		int[] inorder = new int[] { 1, 2, 3 };
		int[] preorder = new int[] { 1, 2, 4, 7, 3, 5, 6, 8};
		int[] inorder = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode root = buildTree(preorder, inorder);
		System.out.println(root);
	}
}
