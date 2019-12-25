package com.lintcode.tree;

import com.lintcode.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 480. 二叉树的所有路径
 * 中文English
 * 给一棵二叉树，找出从根节点到叶子节点的所有路径。
 *
 * 样例
 * 样例 1:
 *
 * 输入：{1,2,3,#,5}
 * 输出：["1->2->5","1->3"]
 * 解释：
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 样例 2:
 *
 * 输入：{1,2}
 * 输出：["1->2"]
 * 解释：
 *    1
 *  /
 * 2
 */
public class BinaryTreePaths {
    /**
     * 使用递归的方式实现
     *
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        binaryTree(root,list,"");

        return list;
    }

    private static void binaryTree(TreeNode root, List<String> list, String str) {
        str += root.val + " ";
        if(root.left == null && root.right == null){
            list.add(str.trim().replace(" ","->"));
        }
        if(root.left != null){
            binaryTree(root.left,list,str);
        }
        if(root.right != null){
            binaryTree(root.right,list,str);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;

        List<String> results = binaryTreePaths(node1);
        results.stream().forEach(System.out::println);
    }
}
