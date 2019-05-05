package com.lintcode.easy;

import java.util.List;

import com.lintcode.node.TreeNode;

/**  
 * 
 * 85. 在二叉查找树中插入节点
中文English
给定一棵二叉查找树和一个新的树节点，将节点插入到树中。

你需要保证该树仍然是一棵二叉查找树。

样例
样例  1:
	输入: tree = {}, node= 1
	输出: {1}
	
	样例解释:
	在空树中插入一个点，应该插入为根节点。

	
样例 2:
	输入: tree = {2,1,4,3}, node = 6
	输出: {2,1,4,3,6}
	
	样例解释: 
	如下：
	
	  2             2
	 / \           / \
	1   4   -->   1   4
	   /             / \ 
	  3             3   6
挑战
能否不使用递归？

注意事项
保证不会出现重复的值
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class InsertNode {
    public static TreeNode insertNode(TreeNode root, TreeNode node) {
    	if(root == null){
    		return node;
    	}
    	if(root.val > node.val){
    		root.left = insertNode(root.left, node);
    	}
    	if(root.val < node.val){
    		root.right = insertNode(root.right, node);
    	}
		return root;
    }
    
    public static void main(String[] args) {
    	TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
//		List<Integer> list = inorderTraversal3(node1);
		TreeNode node = insertNode(node1,node8);
		List<Integer> lists = PreorderTraversal.inorderTraversal(node);
		for (Integer integer : lists) {
			System.out.print(integer + " ");
		}
    }
}
