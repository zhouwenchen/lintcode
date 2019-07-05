package com.lintcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.lintcode.node.TreeNode;

/**  
 * 175. 翻转二叉树
中文English
翻转一棵二叉树。左右子树交换。

样例
样例 1:

输入: {1,3,#}
输出: {1,#,3}
解释:
	  1    1
	 /  =>  \
	3        3
样例 2:

输入: {1,2,3,#,#,4}
输出: {1,3,2,#,4}
解释: 
	
      1         1
     / \       / \
    2   3  => 3   2
       /       \
      4         4
挑战
递归固然可行，能否写个非递归的？
 * @author zhouwenchen@021.com  
 * @date 2019年7月4日 上午11:27:20 
 */
public class InvertBinaryTree {
	
	public static TreeNode invertBinaryTree(TreeNode root) {
		if (root == null) {
			return root;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode temp = new TreeNode(-1);
		TreeNode head = new TreeNode(-1);
		temp = root;
		head = temp;
		queue.add(temp);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			// System.out.println(node.val);
			temp = node;
			TreeNode tempNode = new TreeNode(-1);// 表示的是一个临时的节点
			if (node.left != null) {
				queue.add(node.left);
				tempNode = node.right;
				temp.right = node.left;
			}
			if (node.right != null) {
				if (tempNode != null) {
					queue.add(tempNode);
				}
				temp.left = tempNode;
			}
		}
		return head;
	}
	
	
    public static void invertBinaryTree1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
	

public static void main(String[] args) {
	TreeNode node1 = new TreeNode(1);
	TreeNode node2 = new TreeNode(2);
	TreeNode node3 = new TreeNode(3);
	TreeNode node4 = new TreeNode(4);
	
	node1.left = node2;
	node1.right = node3;
	node3.left = node4;
	
	invertBinaryTree1(node1);
}}
