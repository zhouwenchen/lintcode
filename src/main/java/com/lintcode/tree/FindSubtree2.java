package com.lintcode.tree;

import com.lintcode.node.TreeNode;

import javax.xml.transform.Result;

/**
 * 597. 具有最大平均数的子树
 * 给一棵二叉树，找到有最大平均值的子树。返回子树的根结点。
 *
 * 样例
 * 样例1
 *
 * 输入：
 * {1,-5,11,1,2,4,-2}
 * 输出：11
 * 说明:
 * 这棵树如下所示：
 *      1
 *    /   \
 *  -5     11
 *  / \   /  \
 * 1   2 4    -2
 * 11子树的平均值是4.333，为最大的。
 * 样例2
 *
 * 输入：
 * {1,-5,11}
 * 输出：11
 * 说明:
 *      1
 *    /   \
 *  -5     11
 * 1,-5,11 三棵子树的平均值分别是 2.333,-5,11。因此11才是最大的
 * 注意事项
 * LintCode会打印出根结点为你返回节点的子树，保证有最大平均数子树只有一棵
 */
public class FindSubtree2 {

    static class ResultType{
        public int sum,size;
        public ResultType(){}
        public ResultType(int sum,int size){
            this.sum = sum;
            this.size = size;
        }
    }
    private static TreeNode subtree = null;
    private static ResultType subtreeResult = null;

    public static TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return subtree;
    }

    private static ResultType helper(TreeNode root) {
        if(root == null){
            return new ResultType(0,0);
        }
        // 分治法计算左右子树的平均值
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // 当前subtree的结果是左右两颗子树的和的平均值加上自身
        ResultType result = new ResultType(left.sum + right.sum + root.val,left.size + right.size + 1);
        if(subtree == null || subtreeResult.sum * result.size < result.sum * subtreeResult.size){ // TODO subtreeResult.sum / subtreeResult.size < result.size / result.sum
            subtree = root;
            subtreeResult = result;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node_5 = new TreeNode(-5);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node_2 = new TreeNode(-2);

        node1.left = node_5;
        node1.right = node11;
        node_5.left = node12;
        node_5.right = node2;
        node11.left = node4;
        node11.right = node_2;

        TreeNode root = findSubtree2(node1);
        System.out.println("具有最大平均数的子树" + root.val);
    }
}
