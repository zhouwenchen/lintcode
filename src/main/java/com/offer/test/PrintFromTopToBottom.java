package com.offer.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.lintcode.node.TreeNode;

/**  
 * 从上到下遍历二叉树
 * @author zhouwenchen@021.com  
 * @date 2019年6月21日 上午11:16:13 
 */
public class PrintFromTopToBottom {
	
	/**
	 * 从上到下打印二叉树，层次遍历二叉树
	 * @param root
	 * @return
	 */
	public static List<Integer> printFromTopToBottom(TreeNode root){
		if(root == null){
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		List<Integer> resultList = new ArrayList<Integer>();
 		while(!queue.isEmpty()){
 			TreeNode node = queue.poll();
			resultList.add(node.val);
			if(node.left != null){
				queue.add(node.left);
			}
			if(node.right != null){
				queue.add(node.right);
			}
			
		}
		return resultList;
	}
	
	
	/**
	 * 从上打印二叉树。在同一行的二叉树节点打印在同一行
	 * @return
	 */
	public static void printFromTopToBottom1(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		// 层次遍历二叉树中的节点的值
		int nextLevel = 0; // 下一层数目
		int toBePrint = 1; // 本层还要打印的数目

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.val + "\t");
			if (node.left != null) {
				queue.add(node.left);
				nextLevel++;
			}
			if (node.right != null) {
				queue.add(node.right);
				nextLevel++;
			}
			toBePrint--;
			if (toBePrint == 0) {
				System.out.println();
				toBePrint = nextLevel;
				nextLevel = 0;
			}
		}

	}
	
	
	public static void main(String[] args) {
		TreeNode node8 = new TreeNode(8);
		TreeNode node6 = new TreeNode(6);
		TreeNode node10 = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		TreeNode node9 = new TreeNode(9);
		TreeNode node11 = new TreeNode(11);
		
		node8.left = node6;
		node8.right = node10;
		node6.left = node5;
		node6.right = node7;
		node10.left = node9;
		node10.right = node11;
		
//		List<Integer> lists = printFromTopToBottom(node8);
//		if(lists==null){
//			System.out.println(lists);
//		} else {
//			for (Integer list : lists) {
//				System.out.print(list + "\t");
//			}
//		}
		
		printFromTopToBottom1(node8);
	}
}
