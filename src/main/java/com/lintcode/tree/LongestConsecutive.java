package com.lintcode.tree;

import com.lintcode.node.TreeNode;

/**
 * 595. 二叉树最长连续序列
 * 中文English
 * 给一棵二叉树，找到最长连续路径的长度。
 * 这条路径是指 任何的节点序列中的起始节点到树中的任一节点都必须遵循 父-子 联系。最长的连续路径必须是从父亲节点到孩子节点（不能逆序）。
 *
 * 样例
 * 样例1:
 *
 * 输入:
 * {1,#,3,2,4,#,#,#,5}
 * 输出:3
 * 说明:
 * 这棵树如图所示
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * 最长连续序列是3-4-5，所以返回3.
 * 样例2:
 *
 * 输入:
 * {2,#,3,2,#,1,#}
 * 输出:2
 * 说明:
 * 这棵树如图所示：
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 * 最长连续序列是2-3，而不是3-2-1，所以返回2.
 */
public class LongestConsecutive {

    private static int res = 0;
    /**
     * 使用递归实现的操作
     *
     * @param root 二叉树的根节点
     * @return 二叉树最长连续子序列的长度的值
     */
    public static int longestConsecutive(TreeNode root) {
        if(root == null){
            return res;
        }
        res = 1;
        dfs(root.left, root.val, 1);
        dfs(root.right, root.val, 1);

        return res;
    }

    private static void  dfs(TreeNode root, int val, int i) {
        if(root == null){
            return ;
        }
        if(root.val == val + 1){
            i++;
            res = Math.max(res,i);
        } else {
            i = 1;
        }
        dfs(root.left,root.val,i);
        dfs(root.right,root.val,i);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.right = node3;
        node3.left = node2;
        node3.right = node4;
        node4.right = node5;

        int i = longestConsecutive(node1);
        System.out.println("二叉树最长连续序列 " + i);
    }
}
