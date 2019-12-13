package com.lintcode.middle;

import com.lintcode.node.DoublyListNode;
import com.lintcode.node.TreeNode;

/**
 * 378. 将二叉树转换成双链表
 * 中文English
 * 将一个二叉树按照中序遍历转换成双向链表。
 *
 * 样例
 * 样例 1：
 *
 * 输入:
 * 	    4
 * 	   / \
 * 	  2   5
 * 	 / \
 * 	1   3
 *
 * 输出: 1<->2<->3<->4<->5
 * 样例 2：
 *
 * 输入:
 * 	    3
 * 	   / \
 * 	  4   1
 *
 * 输出:4<->3<->1
 */
public class BstToDoublyList {
    /**
     * 1.先中序遍历二叉树
     * 2.生成双向链表
     * @param root 二叉树的根节点
     * @return 双向链表的实现
     */
    public static DoublyListNode bstToDoublyList(TreeNode root) {
        if(root == null){
            return null;
        }


        DoublyListNode doublyListNode = new DoublyListNode(0);
        return null;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);

        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;

        DoublyListNode doublyListNode = bstToDoublyList(node4);
        while (doublyListNode != null){
            System.out.print(doublyListNode.val + " <-> " );
            doublyListNode = doublyListNode.next;
        }
        System.out.println("null");
    }
}
