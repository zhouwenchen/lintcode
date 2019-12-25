package com.lintcode.tree;

import com.lintcode.node.TreeNode;

import java.util.Stack;

/**
 * 453. 将二叉树拆成链表
 * 中文English
 * 将一棵二叉树按照前序遍历拆解成为一个 假链表。所谓的假链表是说，用二叉树的 right 指针，来表示链表中的 next 指针。
 *
 * 样例
 * 样例 1：
 *
 * 输入：{1,2,5,3,4,#,6}
 * 输出：{1,#,2,#,3,#,4,#,5,#,6}
 * 解释：
 *      1
 *     / \
 *    2   5
 *   / \   \
 *  3   4   6
 *
 * 1
 * \
 *  2
 *   \
 *    3
 *     \
 *      4
 *       \
 *        5
 *         \
 *          6
 * 样例 2：
 *
 * 输入：{1}
 * 输出：{1}
 * 解释：
 *          1
 *          1
 * 挑战
 * 不使用额外的空间耗费。
 *
 * 注意事项
 * 不要忘记将左儿子标记为 null，否则你可能会得到空间溢出或是时间溢出。
 */
public class Flatten {

    /**
     * 前序遍历
     * @param root
     */
    public static void flatten(TreeNode root) {
        // 空节点
        if(root == null){
            return;
        }
        // 左右节点都为空
        if(root.left == null && root.right == null){
            return;
        }

        // 左节点为空
        if(root.left == null){
            TreeNode right = root.right;
            flatten(right);
            return;
        }
        // 右节点为空
        if(root.right == null){
            TreeNode left = root.left;
            root.right = left;

            flatten(left);
            root.left = null;// left 节点设为 null
            return;
        }

        // 左右节点不为空
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = left;

        flatten(left);

        TreeNode p = left;
        while (p.right != null){ // 找到left部分最右节点
            p = p.right;
        }
        p.right = right;
        flatten(right);

        root.left = null;
        return;
    }

    /**
     * 递归实现
     */
    private static TreeNode lastNode = null;
    public static void flatten1(TreeNode root) {
        if(root == null){
            return;
        }
        if(lastNode != null){
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten1(root.left);
        flatten1(right);
    }

    /**
     * 使用栈实现
     * @param root
     */
    public static void flatten2(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
            node.left = null;
            if(stack.isEmpty()){
                node.right = null; // 将叶子节点的右节点设置为 null
            }else {
                node.right = stack.peek();  // 节点的右节点指向链表的下一个节点
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

//        flatten(node1);
//        flatten1(node1);
        flatten2(node1);

        while (node1 != null){
            System.out.print(node1.val + " -> ");
            node1 = node1.right;
        }
        System.out.print("null");
    }
}
