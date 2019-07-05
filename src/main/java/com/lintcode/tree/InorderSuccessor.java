package com.lintcode.tree;

import com.lintcode.node.TreeNode;

/**  
 * 448. 二叉查找树的中序后继
给定一个二叉查找树(什么是二叉查找树)，以及一个节点，求该节点在中序遍历的后继，如果没有则返回null

样例
样例 1:

输入: {1,#,2}, node with value 1
输出: 2
解释: 
  1
   \
    2
样例 2:

输入: {2,1,3}, node with value 1
输出: 2
解释: 
    2
   / \
  1   3
二叉树的表示

挑战
O(h)，其中h是BST的高度。

注意事项
保证p是给定二叉树中的一个节点。(您可以直接通过内存地址找到p)
 * @author zhouwenchen@021.com  
 * @date 2019年6月11日 下午3:23:50 
 */
public class InorderSuccessor {
	
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    	// 1.先中序遍历二叉树，然后在根据p查询该节点的下一个节点信息
    	
       return root;
    }
	public static void main(String[] args) {
		TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		
		node2.left = node1;
		node2.right = node3;
		
		TreeNode node = inorderSuccessor(node2, node1);
		System.out.println(node.val);
	}
}
