package com.offer.test;

import java.util.Stack;

import com.lintcode.node.TreeNode;

/**  
 * 对称二叉树,对于某一个二叉树来说的，不是说不同的二叉树
 * @author zhouwenchen@021.com  
 * @date 2019年6月19日 下午7:28:17 
 */
public class IsSymmetric {
	
	/**
	 * 是否是对称的二叉树
	 * @param root
	 * @param node2
	 * @return
	 */
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root.left);
		stack.push(root.right);

		while (!stack.isEmpty()) {
			TreeNode node1 = stack.pop();// 每次取出两个栈中的元素，这两个元素也就是位置上的对称，还需要判断值是否相等
			TreeNode node2 = stack.pop();
			if (node1 == null && node2 == null) {
				continue;
			}
			if (node1 == null || node2 == null || node1.val != node2.val) {
				return false;
			}
			stack.push(node1.left);// node1的左节点和node2的右节点是对称的节点
			stack.push(node2.right);
			
			stack.push(node1.right);// node1 的右节点和node2的左节点是对称的节点
			stack.push(node2.left);
		}
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node22 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node33 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node44 = new TreeNode(4);
		
		node1.left = node2;
		node1.right = node22;
		node2.left = node3;
		node2.right = node4;
		node22.left = node44;
		node22.right = node33;
		boolean b = isSymmetric(node1);
		System.out.println(b);
	}
}
