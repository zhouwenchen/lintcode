package com.offer.test;

import com.lintcode.node.TreeNode;

/**  
 * 平衡二叉树
 * @author zhouwenchen@021.com  
 * @date 2019年7月18日 上午9:42:56 
 */
public class IsBalanced {
	
	public static boolean isBalanced(TreeNode root) {
		if(root == null){
			return true;
		}
		return isBalanced(root.left) && isBalanced(root.right) && Math.abs(TreeDepth(root.right) - TreeDepth(root.left)) < 2;
	}
	
	/**
	 * 数的深度，使用后序遍历的方式实现
	 * @param left
	 * @return
	 */
	private static int TreeDepth(TreeNode node) {
		if(node == null){
			return 0;
		}
		int left = TreeDepth(node.left);
		int right = TreeDepth(node.right);
		
		return Math.max(left, right) + 1;
	}
	
	/**
	 * 
	 */
	private static boolean isBalance = true;
	public static boolean isBalanced2(TreeNode root){
		if(root == null){
			return true;
		}
		isBalance = true;
		caculateBalanceTree(root);
		
		return isBalance;
	}
	
	private static int caculateBalanceTree(TreeNode node) {
		if(node == null || !isBalance){
			return 0;
		}
	    int left = caculateBalanceTree(node.left);
	    int right = caculateBalanceTree(node.right);
		
	    isBalance = Math.abs(left -right) < 2 ? true: false;
	    return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
//		TreeNode node8 = new TreeNode(8);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node7;
		node3.right = node6;
	
//		node7.left = node8;
		
//		boolean b = isBalanced(node1);
		boolean b = isBalanced2(node1);
		System.out.println(b);
	}
}
