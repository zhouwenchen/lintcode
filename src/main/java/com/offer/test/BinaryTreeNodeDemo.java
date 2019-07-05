package com.offer.test;

import com.lintcode.node.BinaryTreeNode;

/**  
 * 给定一个二叉排序树，和其中的某一个节点，如何找出中序遍历的下一个节点。
 * 其中二叉树的结构是，左右子节点，所有的子节点都有一个指向父节点的指针。
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月13日 下午5:10:04 
 */
public class BinaryTreeNodeDemo {
	/**
	 * 分析：分三种情况,以下情况都是针对的是【当前节点】来说的。
	 * 1.存在右子树的情况下
	 * 2.不存在右子树的情况下
	 * 	2.1. 如果该节点是父节点的左节点
	 * 	2.2. 如果该节点是父节点的右节点
	 * @return
	 */
	public static BinaryTreeNode nextNode(BinaryTreeNode node){
		BinaryTreeNode nextnode = null;
		if(node == null){
			return null;
		}
		// 1. 如果该节点的右子树不为空的情况下(找的就是右子树下最左子节点)
		if (node.right != null) {
			nextnode = node.right;
			while (nextnode.left != null) {
				nextnode = nextnode.left;
			}
		}
		// 2. 如果该节点的右子树为空的话
		if(node.right == null){
			if(node.parent != null){
				// 	2.1. 如果该节点是父节点的左结点
				if(node.parent.left == node){
//					System.out.println("该节点是父节点的左子树");
					nextnode = node.parent;
				} else if(node.parent.right == node){
					//  2.2. 如果该节点是父节点的右节点
					while(node.parent != null && node.parent.right== node){
//						System.out.println("该节点是父节点的右子树"+ node.val);
						node = node.parent;
					}
					nextnode = node.parent;
				}
			}
		}
		return nextnode;
	}
	
	public static void main(String[] args) {
		//创建一棵树
		/**
		 *                  1
		 *        2                   3
		 *    4       5            6      7
		 *      8        9
		 *                     
		 */
		BinaryTreeNode node1 = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		BinaryTreeNode node8 = new BinaryTreeNode(8);
		BinaryTreeNode node9 = new BinaryTreeNode(9);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node8;
		node5.right = node9;
		node3.left = node6;
		node3.right = node7;
		
		node2.parent = node1;
		node3.parent = node1;
		node4.parent = node2;
		node5.parent = node2;
		node8.parent = node5;
		node9.parent = node5;
		node6.parent = node3;
		node7.parent = node3;
		
		BinaryTreeNode node = nextNode(node8);
		if(node != null){
			System.out.println(node.val);
		}else {
			System.out.println(node);
		}
	}
}
