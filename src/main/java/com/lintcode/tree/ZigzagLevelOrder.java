package com.lintcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.lintcode.node.TreeNode;

/**  
 * 71. 二叉树的锯齿形层次遍历
中文English
给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行） 

样例
样例 1:

输入:{1,2,3}
输出:[[1],[3,2]]
解释:
    1
   / \
  2   3
它将被序列化为 {1,2,3}
样例 2:

输入:{3,9,20,#,#,15,7}
输出:[[3],[20,9],[15,7]]
解释:
    3
   / \
  9  20
    /  \
   15   7
它将被序列化为 {3,9,20,#,#,15,7}
 * @author zhouwenchen@021.com  
 * @date 2019年6月10日 上午10:42:10 
 */
public class ZigzagLevelOrder {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> currlevel = new Stack<TreeNode>();
		Stack<TreeNode> nextlevel = new Stack<TreeNode>();
		Stack<TreeNode> temp;

		currlevel.push(root);
		// 从左向右的顺序
		boolean normalOrder = true;
		while (!currlevel.isEmpty()) {
			List<Integer> currentLevelResult = new ArrayList<Integer>();

			while (!currlevel.isEmpty()) {
				TreeNode node = currlevel.pop();
				currentLevelResult.add(node.val);
				if (normalOrder) {
					if (node.left != null) {
						nextlevel.push(node.left);
					}
					if (node.right != null) {
						nextlevel.push(node.right);
					}
				} else {
					if (node.right != null) {
						nextlevel.push(node.right);
					}
					if (node.left != null) {
						nextlevel.push(node.left);
					}
				}
			}
			result.add(currentLevelResult);
			temp = currlevel;
			currlevel = nextlevel;
			nextlevel = temp;
			normalOrder = !normalOrder;
		}

		return result;
	}

	public static void main(String[] args) {
		TreeNode node3 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);

		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;

		List<List<Integer>> list = zigzagLevelOrder(node3);
		for (List<Integer> list2 : list) {
			System.out.println(list2);
		}
	}
}
