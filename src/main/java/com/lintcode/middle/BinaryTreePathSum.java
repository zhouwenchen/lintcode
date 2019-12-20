package com.lintcode.middle;

import com.lintcode.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 376. 二叉树的路径和
 * 中文English
 * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。
 *
 * 一个有效的路径，指的是从根节点到叶节点的路径。
 *
 * 样例
 * 样例1:
 *
 * 输入:
 * {1,2,4,2,3}
 * 5
 * 输出: [[1, 2, 2],[1, 4]]
 * 说明:
 * 这棵树如下图所示：
 * 	     1
 * 	    / \
 * 	   2   4
 * 	  / \
 * 	 2   3
 * 对于目标总和为5，很显然1 + 2 + 2 = 1 + 4 = 5
 * 样例2:
 *
 * 输入:
 * {1,2,4,2,3}
 * 3
 * 输出: []
 * 说明:
 * 这棵树如下图所示：
 * 	     1
 * 	    / \
 * 	   2   4
 * 	  / \
 * 	 2   3
 * 注意到题目要求我们寻找从根节点到叶子节点的路径。
 * 1 + 2 + 2 = 5, 1 + 2 + 3 = 6, 1 + 4 = 5
 * 这里没有合法的路径满足和等于3.
 */
public class BinaryTreePathSum {

    /**
     * 思路：寻找的是根节点到叶子节点上的所有节点和是否等于目标值
     *
     * @param root 二叉树的根节点
     * @param target 目标二叉树的路径和
     * @return 二叉树的路径集合
     */
    public static List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        helper(root,target,list,new ArrayList<Integer>());
        return list;
    }

    /**
     * 递归调用 链表，查找满足路径节点的和
     * @param root 二叉树的根节点的值
     * @param target 目标值的和
     * @param path 满足条件的二叉树的路径集合
     */
    private static void helper(TreeNode root, int target, List<List<Integer>> list, ArrayList<Integer> path) {
        if(root == null) return;
        int sum = 0;
        path.add(root.val);

        // 从头来时遍历
        for(int i = 0; i < path.size();i++){
            sum += path.get(i);
            if(sum == target && i == path.size()-1 && root.left==null && root.right == null){ // TODO 需要判断是否是子节点
                list.add(new ArrayList<>(path));
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
        TreeNode node21 = new TreeNode(1);


        node1.left = node2;
        node1.right = node4;
        node2.left = node22;
        node2.right = node3;
        node22.left = node21;

        List<List<Integer>> resultLists = binaryTreePathSum(node1, 5);
        resultLists.forEach((List<Integer> o) -> System.out.println(o));
    }
}
