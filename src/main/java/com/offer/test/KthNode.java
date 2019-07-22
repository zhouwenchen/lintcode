package com.offer.test;

import java.util.ArrayList;
import java.util.List;

import com.lintcode.node.TreeNode;

/**  
 * 二叉搜索树中第K大的节点
 * 给定一颗二叉树，找出第K大的节点，这个第K大的节点是从小到大的第K个节点，所以也可以说是第K小的节点。
 * 对于一颗二叉树来说，其中序遍历就是节点值从小到大的排列，那么我们用一个ArrayList把中序遍历的结果保存下来，找到第K-1个节点就是第K大的节点
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月17日 上午10:54:07 
 */
public class KthNode {
	
	/**
	 * 思路在于使用中序遍历的方式实现，将遍历的结果存入list集合中
	 * @param root
	 * @return
	 */
	public static TreeNode kthNode(TreeNode root,int k) {
		if(root == null){
			return root;
		}
		List<TreeNode> list = new ArrayList<TreeNode>();
		inOrderRecursive(root,list);
		return list.get(k -1);
	}
	
	/**
	 * 中序遍历的方式
	 * @param root
	 * @param list
	 */
	private static void inOrderRecursive(TreeNode root, List<TreeNode> list) {
		if(root == null){
			return;
		}
		
		inOrderRecursive(root.left, list);
		list.add(root);
		inOrderRecursive(root.right, list);
	}

	public static void main(String[] args) {
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		
		node5.left = node3;
		node5.right = node7;
		node3.left = node2;
		node3.right = node4;
		node7.left = node6;
		node7.right = node8;
		
		TreeNode kthNode = kthNode(node5,3);
		System.out.println(kthNode.val);
	}
}
