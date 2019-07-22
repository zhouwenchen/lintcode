package com.offer.test;

import com.lintcode.node.TreeNode;

/**  
 * 二叉树的深度
 * 
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 * @author zhouwenchen@021.com  
 * @date 2019年7月17日 上午11:18:25 
 */
public class TreeDeep {
	public static int treeDeep(TreeNode root) {
		if(root == null){
			return 0;
		}
		
		int left = treeDeep(root.left) + 1;
		int right = treeDeep(root.right) + 1;
		
		return left > right?left : right;
	}
	
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node7;
		node3.right = node6;
		
		int dep = treeDeep(node1);
		System.out.println(dep);
	}
}
