package com.lintcode.tree;

import com.lintcode.node.TreeNode;

/**  
 * 88. 最近公共祖先
给定一棵二叉树，找到两个节点的最近公共父节点(LCA)。

最近公共祖先是两个节点的公共的祖先节点且具有最大深度。

样例
样例 1:

输入：{1},1,1
输出：1
解释：
 二叉树如下（只有一个节点）:
         1
 LCA(1,1) = 1
样例 2:

输入：{4,3,7,#,#,5,6},3,5
输出：4
解释：
 二叉树如下:

      4
     / \
    3   7
       / \
      5   6
			
 LCA(3, 5) = 4
注意事项
假设给出的两个节点都在树中存在
 * @author zhouwenchen@021.com  
 * @date 2019年6月10日 下午5:07:35 
 */
public class LowestCommonAncestor {

	/**
	 * 使用递归的方式实现的
	 * @param root
	 * @param A
	 * @param B
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null) {
			return null;
		}
		if (root == A || root == B) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, A, B);

		TreeNode right = lowestCommonAncestor(root.right, A, B);

		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode node4 = new TreeNode(4);
		TreeNode node3 = new TreeNode(3);
		TreeNode node7 = new TreeNode(7);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);

		node4.left = node3;
		node4.right = node7;
		node7.left = node5;
		node7.right = node6;

		TreeNode node = lowestCommonAncestor(node4, node3, node3);
		System.out.println(node.val);
	}
}

