package com.lintcode.tree;

import com.lintcode.node.ListNode;
import com.lintcode.node.TreeNode;

/**
 * 375. 克隆二叉树
 * 中文English
 * 深度复制一个二叉树。
 *
 * 给定一个二叉树，返回一个他的 克隆品 。
 *
 * 样例
 * 样例1:
 *
 * 输入: {1,2,3,4,5}
 * 输出: {1,2,3,4,5}
 * 解释：
 * 样例中二叉树如下所示:
 *      1
 *    /  \
 *   2    3
 *  / \
 * 4   5
 * 样例2:
 *
 * 输入: {1,2,3}
 * 输出: {1,2,3}
 * 解释：
 * 样例中二叉树如下所示:
 *    1
 *  /  \
 * 2    3
 * 注意事项
 * 你最好不要仅仅通过return root来通过此题。
 */
public class CloneTree {
    public static TreeNode cloneTree(TreeNode root) {
        if(root == null){
            return null; // 搜索到了空节点，直接返回
        }

        TreeNode clone_root = new TreeNode(root.val);
        clone_root.left= cloneTree(root.left);
        clone_root.right = cloneTree(root.right);

        return clone_root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode root = cloneTree(node1);
        // TODO 二叉树的层序遍历操作
        System.out.println(root.val);
    }
}
