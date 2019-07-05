package com.offer.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.lintcode.node.TreeNode;


/**  
 * 之字形打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月21日 下午3:35:13 
 */
public class PrintZRoutTree {
	
	public static List<List<Integer>> printZRoutTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		// 创建两个栈
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list1 = new ArrayList<Integer>();
		stack1.push(root);
		list1.add(root.val);
		result.add(list1);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			list1 = new ArrayList<Integer>();
			// 奇数行，从左到右
			if(stack2.isEmpty()){
				while(!stack1.isEmpty()){
					TreeNode node = stack1.pop();
					if(node.right != null){
						stack2.push(node.right);
						list1.add(node.right.val);
					}
					if(node.left != null){
						stack2.push(node.left);
						list1.add(node.left.val);
					}
				}
			}else { // 偶数行，从右到左
				while(!stack2.isEmpty()){
					TreeNode node = stack2.pop();
					if(node.left != null){
 						stack1.push(node.left);
						list1.add(node.left.val);
					}
					if(node.right != null){
						stack1.push(node.right);
						list1.add(node.right.val);
					}
				}
			}
			if(list1.size() > 0){
				result.add(list1);
			}
		}
		
		return result;
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
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
		TreeNode node12 = new TreeNode(12);
		TreeNode node13 = new TreeNode(13);
		TreeNode node14 = new TreeNode(14);
		TreeNode node15 = new TreeNode(15);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node4.right = node9;
		node5.left = node10;
		node5.right = node11;
		node6.left = node12;
		node6.right = node13;
		node7.left = node14;
		node7.right = node15;
		
		List<List<Integer>> lists = printZRoutTree(node1);
		for (List<Integer> list : lists) {
			System.out.println(list);
		}
	}
}
