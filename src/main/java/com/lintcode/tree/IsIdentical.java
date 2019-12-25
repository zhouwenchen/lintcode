package com.lintcode.tree;

import com.lintcode.node.TreeNode;

/**
 * 469. 等价二叉树
 * 中文English
 * 检查两棵二叉树是否等价。等价的意思是说，首先两棵二叉树必须拥有相同的结构，并且每个对应位置上的节点上的数都相等。
 *
 * 样例
 * 样例 1:
 *
 * 输入：{1,2,2,4}，{1,2,2,4}
 * 输出：true
 * 解释：
 *         1                   1
 *        / \                 / \
 *       2   2   和          2   2
 *      /                   /
 *     4                   4
 *
 * 是相同的。
 * 样例 2:
 *
 * 输入：{1,2,3,4}，{1,2,3,#,4}
 * 输出：false
 * 解释：
 *
 *         1                  1
 *        / \                / \
 *       2   3   和          2  3
 *      /                        \
 *     4                          4
 * 不一样。
 */
public class IsIdentical {
    /**
     * 使用递归的方式判断
     * 思路：a的左子树和b的左子树节点相同
     *      a的右子树和b的右子树节点相同
     * @param a 二叉树a
     * @param b 二叉树b
     * @return
     */
    public static boolean isIdentical(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;

        if(a.val != b.val)return false;

        return isIdentical(a.left,b.left) && isIdentical(a.right,b.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        TreeNode node11 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node31 = new TreeNode(3);
        TreeNode node41 = new TreeNode(4);

        node11.left = node21;
        node11.right = node31;
        node21.left = node41;

        boolean b = isIdentical(node1, node11);
        System.out.println("是否是等价二叉树：\t"+ b);
    }
}
