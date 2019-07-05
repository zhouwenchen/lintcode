package com.lintcode.tree;

import com.lintcode.node.TreeNode;

/**  
 * 72. 中序遍历和后序遍历树构造二叉树
根据中序遍历和后序遍历树构造二叉树

样例
样例 1:

输入：[],[]
输出：{}
解释：
二叉树为空
样例 2:

输入：[1,2,3],[1,3,2]
输出：{2,1,3}
解释：
二叉树如下
  2
 / \
1   3
注意事项
你可以假设树中不存在相同数值的节点
 * @author zhouwenchen@021.com  
 * @date 2019年6月10日 下午1:49:19 
 */
public class BuildTree {
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		// 1.如果两个数组长度不同，返回null
		if (inorder.length != postorder.length) {
			return null;
		}
		return myBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}
	
	public static TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
		if (instart > inend) {
			return null;
		}
		
		// 2.后序遍历的最后一个值，是根节点，在中序排序中，找到这个根节点
		TreeNode root = new TreeNode(postorder[postend]);

		int position = findPositon(inorder, instart, inend, postorder[postend]);

		root.left = myBuildTree(inorder, instart, position - 1, postorder, poststart, poststart + position - instart - 1);

		root.right = myBuildTree(inorder, position + 1, inend, postorder, poststart + position - instart, postend - 1);

		return root;
	}
	
	/**
	 * 在中序遍历中查找根节点的位置，从而可以判断中序遍历的根节点的左右的节点
	 * @param inorder
	 * @param instart
	 * @param inend
	 * @param i
	 * @return
	 */
	private static int findPositon(int[] inorder, int instart, int inend, int key) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] inorder = new int[] { 1, 2, 3 };
		int[] postorder = new int[] { 1, 3, 2 };
		TreeNode tree = buildTree(inorder, postorder);
		System.out.println(tree);
	}
}
