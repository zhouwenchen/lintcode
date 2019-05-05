package com.lintcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.lintcode.node.TreeNode;

/**  
 * 155. 二叉树的最小深度
中文English
给定一个二叉树，找出其最小深度。

二叉树的最小深度为根节点到最近叶子节点的距离。
样例
样例 1:

输入: {}
输出: 0
样例 2:

输入:  {1,#,2,3}
输出: 3	
解释:
	1
	 \ 
	  2
	 /
	3    
样例 3:

输入:  {1,2,3,#,#4,5}
输出: 2	
解释: 
      1
     / \ 
    2   3
       / \
      4   5  
 * @author zhouwenchen@021.com  
 * @date 2019年4月17日 下午4:17:25 
 */
public class MinDepth {
	
	
	/**
	 * 递归的方式实现
	 * @param root
	 * @return
	 */
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		if (left == 0 || right == 0) {
			return left + right + 1;
		}
		return Math.min(left, right) + 1;
	}
	
	/**
	 * BFS(广度优先遍历方式)
	 * @param root
	 * @return
	 */
	public static int minDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<TreeNode> layerList = new LinkedList<TreeNode>();
		queue.addFirst(root);
		int start = 0;
		int end = 1;
		int level = 1;

		while (!queue.isEmpty()) {
			TreeNode temp = queue.removeLast();
			start++;
			layerList.addFirst(temp);
			if (temp.left == null && temp.right == null) {
				return level;
			}
			if (temp.left != null) {
				queue.addFirst(temp.left);
			}
			if (temp.right != null) {
				queue.addFirst(temp.right);
			}
			if (start == end) {
				level++;
				start = 0;
				end = queue.size();
				layerList = new LinkedList<TreeNode>();
			}
		}
		return level;
	}
	
	/**
	 * 使用层次遍历的方式，
	 * 来个非递归的，思路是层序遍历，找到第一个左右结点都为null的情况，就返回
	 * @param root
	 * @return
	 */
	public static int minDepth2(TreeNode root) {
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return 1;
		}
		int depth = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int len = queue.size();
			depth++;
			for (int i = 0; i < len; i++) {
				TreeNode cur = queue.poll();
				if (cur.left == null && cur.right == null) {
					return depth;
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
		}
		return 0;
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
		node3.left = node6;
		node3.right = node7;
		
		int i = minDepth2(node1);
		System.out.println(i);
	
	}
}
