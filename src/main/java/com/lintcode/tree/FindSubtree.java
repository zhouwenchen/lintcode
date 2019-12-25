package com.lintcode.tree;

import com.lintcode.node.TreeNode;

/**
 * 596. 最小子树
 * 中文English
 * 给一棵二叉树, 找到和为最小的子树, 返回其根节点。输入输出数据范围都在int内。
 *
 * 样例
 * 样例 1:
 *
 * 输入:
 * {1,-5,2,1,2,-4,-5}
 * 输出:1
 * 说明
 * 这棵树如下所示：
 *      1
 *    /   \
 *  -5     2
 *  / \   /  \
 * 1   2 -4  -5
 * 整颗树的和是最小的，所以返回根节点1.
 * 样例 2:
 *
 * 输入:
 * {1}
 * 输出:1
 * 说明:
 * 这棵树如下所示：
 *    1
 * 这棵树只有整体这一个子树，所以返回1.
 * 注意事项
 * LintCode会打印根节点为你返回节点的子树。保证只有一棵和最小的子树并且给出的二叉树不是一棵空树。
 */
public class FindSubtree {
    /** 定义一个最小的节点的值*/
    private static TreeNode m_subRoot = null;
    /** 初始化最小值*/
    private static int m_subSum = Integer.MAX_VALUE;
    /**
     * 最小子树
     * @param root
     * @return
     */
    public static TreeNode findSubtree(TreeNode root) {
        if(root == null){
            return null;
        }
        subTree(root);
        return m_subRoot;
    }

    /**
     * 求子树
     * @param root
     */
    private static int subTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftSum = subTree(root.left);
        int rightSum = subTree(root.right);

        int sum = leftSum + rightSum + root.val;

        // 找到最小值
        if(sum <= m_subSum){
            m_subSum = sum;
            m_subRoot = root;
        }
        return sum;
    }

    /**
     * 第二种实现方式，和第一种不同的是，没有用两个成员变量来接收
     * @param root
     * @return
     */
    private static TreeNode subTree = null;
    private static int subtreeSum = Integer.MAX_VALUE;
    public static TreeNode findSubtree1(TreeNode root){
        helper(root);
        return subTree;
    }

    private static int helper(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = helper(root.left) + helper(root.right) + root.val;
        if(sum < subtreeSum){
            subTree = root;
            subtreeSum = sum;
        }
        return sum;
    }

    /**
     * TODO 如果求的是最大子树
     * @param root 二叉树的根节点
     */
    private static TreeNode maxRoot = null;
    private static int maxSum = Integer.MIN_VALUE;
    public static TreeNode findSubtree2(TreeNode root) {
        helperFindSubMaxTree(root);
        return maxRoot;
    }

    /**
     * 最大子树
     * @param root
     */
    private static int helperFindSubMaxTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int temp = helperFindSubMaxTree(root.left) + helperFindSubMaxTree(root.right) + root.val;
        if(maxSum <= temp){
            maxSum = temp;
            maxRoot = root;
        }
        return temp;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node_5 = new TreeNode(-5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node11 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node_4 = new TreeNode(-4);
        TreeNode node_51 = new TreeNode(-5);

        node1.left = node_5;
        node1.right = node2;
        node_5.left = node11;
        node_5.right = node21;
        node2.left = node_4;
        node2.right = node_51;

//        TreeNode root = findSubtree(node1);
//        TreeNode root = findSubtree1(node1);
        TreeNode root = findSubtree2(node1);
        System.out.println("最小子树的节点是:" + root.val);
    }
}
