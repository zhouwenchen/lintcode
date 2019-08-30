package com.lintcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.lintcode.node.TreeNode;

/**  
 * 175. 翻转二叉树,二叉树的镜像
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
	
	
	/**
	 * 递归调用当前节点的左右子节点的互换位置
	 * @param root
	 * @return
	 */
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
			TreeNode node = queue.poll();// 存储当前节点的左右节点
			// System.out.println(node.val);
			temp = node;
			TreeNode tempNode = new TreeNode(-1);// 表示的是一个临时的节点
			if (node.left != null) { // 左节点不为空的话，替换当前节点为右节点
				queue.add(node.left); // 当前左节点先入队列。以便下一次遍历
				tempNode = node.right;// 先将当前节点的右节点存储起来
				temp.right = node.left;// 左节点替换到右节点
			}
			if (node.right != null) {// 如果当前右节点不为空的话
				if (tempNode != null) {// 如果临时节点存储的是当前节点的右节点，且不为空的话，那么就将临时节点（右节点）添加到队列中
					queue.add(tempNode); //
				}
				temp.left = tempNode; // 临时节点（右节点）替换左节点
			}
		}
		return head;// 返回头结点
	}
	
	
    public static void invertBinaryTree1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left; // 将根节点定义为临时节点
        root.left = root.right;		 
        root.right = temp; 			// 左右节点的互换
        
        invertBinaryTree(root.left);//	递归左节点
        invertBinaryTree(root.right);//	递归右节点
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
	}
}
