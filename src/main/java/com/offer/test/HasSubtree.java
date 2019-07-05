package com.offer.test;

import com.lintcode.node.TreeNode;

/**  
 * 数的子结构
 * 
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author zhouwenchen@021.com  
 * @date 2019年6月19日 下午4:06:17 
 */
public class HasSubtree {
	
	public static boolean hasSubtree(TreeNode node1,TreeNode node2){
		if(node1 == null || node2 == null){
			return false;
		}
		
		return isSubTree(node1,node2) || isSubTree(node1.left,node2) || isSubTree(node1.right,node2);
	}
	
	/**
	 * 递归调用查看左子树和右子树
	 * @param right
	 * @param node2
	 * @return
	 */
	private static boolean isSubTree(TreeNode node1, TreeNode node2) {
		  if(node2 == null) return true;
	        if(node1 == null) return false;
	        if(node1.val == node2.val) return isSubTree(node1.left, node2.left)
	                && isSubTree(node1.right, node2.right);
	        return false;

	}

	public static void main(String[] args) {
		TreeNode node8 = new TreeNode(8);
		TreeNode node88 = new TreeNode(8);
		TreeNode node7 = new TreeNode(7);
		TreeNode node9 = new TreeNode(9);
		TreeNode node2 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node77 = new TreeNode(7);
		
		
		node8.left = node88;
		node8.right = node7;
		node88.left = node9;
		node88.right = node2;
		node2.left = node4;
		node2.right = node77;
		
		TreeNode node888 = new TreeNode(8);
		TreeNode node99 = new TreeNode(9);
		TreeNode node22 = new TreeNode(2);
		
		node888.left = node99;
		node888.right = node22;
		
		
		boolean b = hasSubtree(node8,node888);
		System.out.println(b);
	}
}
