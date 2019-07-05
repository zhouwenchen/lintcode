package com.offer.test;

import java.util.ArrayList;
import java.util.List;

import com.lintcode.node.TreeNode;

/**  
 * 二叉树中和为某一值的路径
 * 　输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月21日 下午8:27:04 
 */
public class FindPath {
	
	public static void findPath(TreeNode root, int target) {
		if (root == null) {
			return;
		}

		List<Integer> lists = new ArrayList<Integer>();
		printPath(root, target, lists);
	} 
	
	/**
	 * 打印节点的值
	 * @param root
	 * @param target
	 * @param lists
	 */
	private static void printPath(TreeNode node, int target, List<Integer> lists) {
		if (node == null) {
			return;
		}
		lists.add(node.val);
		target -= node.val;
		if (target == 0 && node.left == null && node.right == null) {
			for (Integer list : lists) {
				System.out.print(list + "\t");
			}
			System.out.println();
		} else {
			printPath(node.left, target, lists);
			printPath(node.right, target, lists);
		}
		lists.remove(lists.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode node10 = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node12 = new TreeNode(12);

		node10.left = node5;
		node10.right = node12;
		node5.left = node4;
		node5.right = node7;
		findPath(node10,22);
	}
}
