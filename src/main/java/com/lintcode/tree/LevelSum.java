package com.lintcode.tree;

import com.lintcode.node.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 482. 二叉树的某层节点之和
 * 中文English
 * 给出一棵二叉树和一个整数代表树的某层深度。
 * 计算二叉树的某层节点之和。
 *
 * 样例
 * 样例 1:
 *
 * 输入：{1,2,3,4,5,6,7,#,#,8,#,#,#,#,9},2
 * 输出：5
 * 解释：
 *      1
 *    /   \
 *   2     3
 *  / \   / \
 * 4   5 6   7
 *    /       \
 *   8         9
 * 2+3=5
 * 样例 2:
 *
 * 输入：{1,2,3,4,5,6,7,#,#,8,#,#,#,#,9},3
 * 输出：22
 * 解释：
 *      1
 *    /   \
 *   2     3
 *  / \   / \
 * 4   5 6   7
 *    /       \
 *   8         9
 * 4+5+6+7=22
 */
public class LevelSum {
    /**
     * stack1 表示存储根节点
     * stack2 表示根节点的左右子节点
     *
     * @param root 二叉树根节点
     * @param level 二叉树的层序的节点
     * @return 层序遍历的节点的和
     */
    public static int levelSum(TreeNode root, int level) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        stack1.push(root);
        int sum = 0;
        for(int i = 1; i <= level;i++){
            sum = 0;
            Stack<TreeNode> stack2 = new Stack<TreeNode>();
            while (!stack1.isEmpty()){
                TreeNode temp = stack1.pop();
                sum += temp.val;

                if(temp.left != null){
                    stack2.push(temp.left);
                }
                if(temp.right != null){
                    stack2.push(temp.right);
                }
            }
            stack1 = stack2;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node7.right = node9;

        int sum = levelSum(node1, 2);
        System.out.println("二叉树的某层节点之和为" + sum);
    }
}
