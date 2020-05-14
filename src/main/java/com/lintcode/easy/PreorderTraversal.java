package com.lintcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.lintcode.node.TreeNode;

/**  
 * 66. 二叉树的前序遍历
给出一棵二叉树，返回其节点值的前序遍历。

样例
Example 1:

Input：{1,2,3}
Output：[1,2,3]
解释：
前序遍历
Example 2:

Input：{1,#,2,3}
Output：[1,2,3]
解释：
前序遍历
挑战
你能使用非递归实现么？

注意事项
首个数据为根节点，后面接着是其左儿子和右儿子节点值，"#"表示不存在该子节点。
节点数量不超过20

      1
    /   \
   2     3
  / \   /  \
 4  5  6    7

二叉树节点为 1,2,3,4,5,6,7
前序遍历：1 2 4 5 3 6 7 
中序遍历：4 2 5 1 6 3 7
后序遍历：4 5 2 6 7 3 1
层次遍历：1 2 3 4 5 6 7
深度优先：1 2 4 5 3 6 7
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class PreorderTraversal {
	
	private static List<Integer> resultList = new ArrayList<Integer>();
	private static List<List<Integer>> resultList1 = new ArrayList<>();
	
    /** 前序遍历 ,非递归的方式实现的
     * @param root
     * @return
     */
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<TreeNode> p = new ArrayList<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		while (root != null || p.size() != 0) {
			while (root != null) {
				p.add(root);
				res.add(root.val);
				root = root.left;
			}
			root = p.get(p.size() - 1);
			p.remove(p.size() - 1);
			root = root.right;
		}
		return res;
	}
	
	/** 前序遍历 ,递归的方式实现的
	 * @param root
	 * @return
	 */
	public static List<Integer> preorderTraversal2(TreeNode root) {
		if(root != null){
			resultList.add(root.val);
		}
		TreeNode left = root.left;
		if(left != null){
			preorderTraversal2(left);
		}
		TreeNode right = root.right;
		if(right != null){
			preorderTraversal2(right);
		}
		return resultList;
	}
	
	/**
	 * 前序遍历，递归的方式实现的
	 * @param root
	 * @return
	 */
	public static List<Integer> preorderTraversal3(TreeNode root) {
		if (root != null) {
			resultList.add(root.val);
			preorderTraversal3(root.left);
			preorderTraversal3(root.right);
		}
		return resultList;
	}
	
	// TODO ===========================
	/** 中序遍历 ，非递归调用
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<TreeNode> p = new ArrayList<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		while (root != null || p.size() != 0) {
			while (root != null) {
				p.add(root);
				root = root.left;
			}
			root = p.get(p.size() - 1);
			p.remove(p.size() - 1);
			res.add(root.val);
			root = root.right;
		}
		return res;
	}
	
	/** 中序遍历 递归调用
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal2(TreeNode root) {
		TreeNode left = root.left;
		if(left != null){
			inorderTraversal2(left);
		}
		if(root!=null){
			resultList.add(root.val);
		}
		TreeNode right = root.right;
		if(right != null){
			inorderTraversal2(right);
		}
		return resultList;
	}
	
	/**
	 * 中序遍历，递归的方式实现的
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal3(TreeNode root) {
		if (root != null) {
			inorderTraversal3(root.left);
			resultList.add(root.val);
			inorderTraversal3(root.right);
		}
		return resultList;
	}
	
	// TODO ===========================
	/** 后序遍历 ，非递归调用 TODO 这个有问题
	 * @param root
	 * @return
	 */
	public static List<Integer> postorderTraversal(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		/* 用来记录最新出栈的节点，
		 * 如果当前节点的右儿子与flag相同，说明当前节点右子树已完成遍历
		 */
		TreeNode flag = null;
		ArrayList<Integer> ans = new ArrayList<Integer>(20);
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		while (!stack.isEmpty()) {
			cur = stack.pop();
			if (cur.right == null || cur.right == flag) {
				ans.add(cur.val);
				flag = cur;
			} else {
				stack.push(cur);
				cur = cur.right;
				while (cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
			}
		}
		return ans;
	}
	
	/** 后序遍历 递归调用
	 * @param root
	 * @return
	 */
	public static List<Integer> postorderTraversal1(TreeNode root) {
		TreeNode left = root.left;
		if(left != null){
			postorderTraversal1(left);
		}
		TreeNode right = root.right;
		if(right != null){
			postorderTraversal1(right);
		}
		if(root!=null){
			resultList.add(root.val);
		}
		return resultList;
	}
	
	/**
	 * 后序遍历，递归的方式实现的
	 * @param root
	 * @return
	 */
	public static List<Integer> postorderTraversal2(TreeNode root) {
		if (root != null) {
			postorderTraversal2(root.left);
			postorderTraversal2(root.right);
			resultList.add(root.val);
		}
		return resultList;
	}
	
	// TODO ===========================
	
	/**
	 * 层次遍历
	 */
	public static List<Integer> levelTraverse(TreeNode root){
		if(root == null){
			return null;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			resultList.add(node.val);
			if(node.left != null){
				queue.offer(node.left);
			}
			if(node.right != null){
				queue.offer(node.right);
			}
		}
		return resultList;
	}
 
	// TODO =======================================
	/**
	 * 深度优先遍历方式
	 * @param root
	 * @return
	 */
	public static List<Integer> depthTraversal(TreeNode root){
		if(root == null){
			return null;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			resultList.add(node.val);
			if(node.right!=null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
		}
		return resultList;
	}
	
	/**
	 * 深度优先遍历，递归方式实现
	 * @param root
	 * @return
	 */
	public static List<Integer> depthTraversal1(TreeNode root){
		if(root == null){
			return null;
		}
		resultList.add(root.val);
		depthTraversal1(root.left);
		depthTraversal1(root.right);
		return resultList;
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
		
//		node7.right = node8;
//		List<Integer> list = inorderTraversal(node1);
//		List<Integer> list = inorderTraversal(node1);
// 		List<Integer> list = preorderTraversal3(node1);
// 		List<Integer> list = postorderTraversal(node1);
// 		List<Integer> list = levelTraverse(node1);
 		List<Integer> list = depthTraversal(node1);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
	}
}
