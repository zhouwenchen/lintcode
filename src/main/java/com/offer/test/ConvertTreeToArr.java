package com.offer.test;

import com.lintcode.node.TreeNode;

/**  
 * 二叉搜索树和双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路：
 *  遍历的时候，就相当于使用中序遍历的方式
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月24日 下午1:50:21 
 */
public class ConvertTreeToArr {

	public static TreeNode conver(TreeNode node) {
		if (node == null) {
			return null;
		}
		if (node.left == null && node.right == null) {
			return node;
		}

		TreeNode leftNode = conver(node.left);
		TreeNode curNode = leftNode;
		while (curNode != null && curNode.right != null) {
			curNode = curNode.right;
		}
		// 找到左子树最右边的叶子节点
		if (curNode != null && curNode.right != null) {
			curNode = curNode.right;
		}

		// 连接根节点与左子树的最右子节点
		if (leftNode != null) {
			node.left = curNode;
			curNode.right = node;
		}

		// 右子树的最左叶子节点
		TreeNode rightNode = conver(node.right);
		if (rightNode != null) {
			node.right = rightNode;
			rightNode.left = node;
		}

		return leftNode == null ? node : leftNode;
	}

	public static void main(String[] args) {
		TreeNode node10 = new TreeNode(10);
		TreeNode node6 = new TreeNode(6);
		TreeNode node14 = new TreeNode(14);
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node12 = new TreeNode(12);
		TreeNode node16 = new TreeNode(16);

		node10.left = node6;
		node10.right = node14;
		node6.left = node4;
		node6.right = node8;
		node14.left = node12;
		node14.right = node16;

		TreeNode resultNode = conver(node10);
		System.out.println(resultNode.val);
	}
}
