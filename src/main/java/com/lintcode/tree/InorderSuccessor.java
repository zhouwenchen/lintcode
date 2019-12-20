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

	/**
	 * 思路：中序遍历的 特性，左-根-右节点 的遍历
	 * 		1.如果当前节点有右节点，则下一个遍历的是右子树的最左节点
	 * 		2.如果当前节点没有右子节点，若它是父节点的左节点的话，则下一个遍历的是父节点
	 * 		3.如果当前节点没有右子节点，若它是父节点的右节点的话，则下一个遍历的就是该父节点的根节点，一直到根节点为止
	 * 		4.如果以上都不满足的话，则无后继节点的值
	 *
	 * 	TODO 代码逻辑有待验证正确性
	 *
	 * @param root
	 * @param p
	 * @return
	 */
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    	// 1.先中序遍历二叉树，然后在根据p查询该节点的下一个节点信息
    	if(root == null){
    		return null;
		}
		// successor 记录用于记录中序遍历当前结点可能的后继结点
		// 后继结点是不是 successor 需要根据当前结点是否存在右子树来确定
		TreeNode successor = null;
    	while (root != null && root != p){
    		// p 在当前节点的左子树
			if(root.val > p.val){
				successor = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}

    	// 循环结束的话，定位到p点的位置
		// 当前节点没有右子树
		if(root.right == null){
			return successor;
		}
		// 当前节点存在右子树，一直找到右子树最左边节点
		root = root.right;
		while (root.right != null){
			root = root.right;
		}
		// TODO
       return root;
    }
	public static void main(String[] args) {
		TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);

		node2.left = node1;
		node2.right = node3;

//		TreeNode node1 = new TreeNode(1);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node5 = new TreeNode(5);
//		TreeNode node6 = new TreeNode(6);
//		TreeNode node7 = new TreeNode(7);
//
//		node1.left = node2;
//		node1.right = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.left = node6;
//		node3.right = node7;

		TreeNode node = inorderSuccessor(node1, node3);
		System.out.println(node.val);
	}
}
