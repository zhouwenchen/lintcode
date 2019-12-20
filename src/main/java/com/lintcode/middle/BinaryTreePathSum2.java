package com.lintcode.middle;

import com.lintcode.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 246. 二叉树的路径和 II
 * 给一棵二叉树和一个目标值，设计一个算法找到二叉树上的和为该目标值的所有路径。路径可以从任何节点出发和结束，但是需要是一条一直往下走的路线。也就是说，路径上的节点的层级是逐个递增的。
 *
 * 样例
 * 样例1：
 *
 * 输入:
 * {1,2,3,4,#,2}
 * 6
 * 输出:
 * [[2, 4],[1, 3, 2]]
 * 解释:
 * 这棵二叉树如图所示：
 *     1
 *    / \
 *   2   3
 *  /   /
 * 4   2
 * 对于给定目标值6, 很显然有 2 + 4 = 6 和 1 + 3 + 2 = 6 两条路径。
 * 样例2：
 *
 * 输入:
 * {1,2,3,4}
 * 10
 * 输出:
 * []
 * 解释:
 * 这棵二叉树如图所示：
 *     1
 *    / \
 *   2   3
 *  /
 * 4
 * 对于给定目标值10, 没有符合条件的答案。
 */
public class BinaryTreePathSum2 {

    /**
     * TODO 需要思考实现方式，递归遍历的方式实现
     *
     * @param root 二叉树的根节点
     * @param target 二叉树的路径和
     * @return 满足目标的二叉树的路径节点的值
     */
    public static List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        helper(root,target,list,new ArrayList<Integer>());
        return list;
    }

    /**
     * 帮助类
     * @param root 根节点
     * @param target 目标的路径和
     * @param list 封装结果的 集合
     * @param path 封装 树 中的路径
     */
    private static void helper(TreeNode root, int target, List<List<Integer>> list, ArrayList<Integer> path) {
        if(root == null) return;
        int sum = 0;
        path.add(root.val);

        for(int i = path.size() - 1; i >= 0; i--){
            sum += path.get(i);

            if(sum == target){
                list.add(new ArrayList<>(path.subList( i, path.size())));
            }
        }
        if(root.left != null){
            helper(root.left,target,list,path);
        }
        if(root.right != null){
            helper(root.right,target,list,path);
        }
        path.remove(path.size()-1 );
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node22 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node22;

        List<List<Integer>> resultLists = binaryTreePathSum2(node1, 6);
        resultLists.forEach((List<Integer> o) -> System.out.println(o));
    }
}
