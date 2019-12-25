package com.lintcode.tree;

import com.lintcode.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 468. 对称二叉树
 * 中文English
 * 给你一颗二叉树，判断是否是对称二叉树
 *
 * 样例
 * 样例 1:
 *
 * 输入：{1,2,2,3,4,4,3}
 * 输出：true
 * 解释：
 *
 *          1
 *         / \
 *        2   2
 *       / \ / \
 *       3 4 4 3
 *
 * 是一个对称的二叉树。
 * 样例 2:
 *
 * 输入：{1,2,2,#,3,#,3}
 * 输出：false
 * 解释：
 *
 *          1
 *         / \
 *         2  2
 *         \   \
 *          3   3
 *
 * 不是对称的二叉树。
 * 挑战
 * 你能递归地和迭代地解决它吗？
 */
public class IsSymmetric {

    /**
     * 思路：递归方式的实现
     *    1. 左子树的左子树和右子树的右子树相同
     *    2.左子树的右子树和右子树的左子树相同
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return comRoot(root.left,root.right);
    }

    /**
     * 递归实现
     * @param left
     * @param right
     * @return
     */
    private static boolean comRoot(TreeNode left, TreeNode right) {
        if(left == null){
            return right == null;
        }
        if(right == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }

        return comRoot(left.left,right.right) && comRoot(left.right,right.left);
    }

    /**
     * 迭代实现的：
     *     1.使用队列实现，先入队列两个root节点
     *     2.添加队列的时候，先左子树的左节点和右子树的右节点    左子树的右节点和右子树的左节点
     *     3.取出队列中的连续的两个节点，如果不一样，返回false
     * @param root 根节点
     * @return 是否是对称二叉树
     */
    public static boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            // 需要判断是否为空和相等的情况
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node33 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node44 = new TreeNode(4);

        node1.left = node2;
        node1.right = node22;
        node2.left = node3;
        node2.right = node4;
        node22.left = node44;
        node22.right = node33;

//        boolean b = isSymmetric(node1);
        boolean b = isSymmetric1(node1);
        System.out.println(b);
    }
}
