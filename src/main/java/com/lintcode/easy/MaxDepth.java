package com.lintcode.easy;

import com.lintcode.node.TreeNode;

/**  
 * 97. 二叉树的最大深度
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的距离。

样例
Example 1:

Input: tree = {}
Output: 0
Explanation: The height of empty tree is 0.
Example 2:

Input: tree = {1,2,3,#,#,4,5}
Output: 3	
Explanation: Like this:
   1
  / \                
 2   3                
    / \                
   4   5
 * @author zhouwenchen@021.com  
 * @date 2019年4月17日 下午3:53:23 
 */
public class MaxDepth {
	
    public static int maxDepth(TreeNode root) {
    	if(root == null){
    		return 0;
    	}
    	int left = maxDepth(root.left);
    	int right = maxDepth(root.right);
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
		
//		node1.left = node2;
		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.left = node6;
		node3.right = node7;
		
		int i = maxDepth(node1);
		System.out.println(i);
	}
}
