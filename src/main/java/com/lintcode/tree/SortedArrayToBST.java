package com.lintcode.tree;

import com.lintcode.node.TreeNode;

/**
 * 177. 把排序数组转换为高度最小的二叉搜索树
 * 中文English
 * 给一个排序数组（从小到大），将其转换为一棵高度最小的二叉sou's树。
 *
 * 样例
 * 样例 1:
 *
 * 输入：[]
 * 输出：{}
 * 解释：二叉搜索树为空
 * 样例 2:
 *
 * 输入：[1,2,3,4,5,6,7]
 * 输出： {4,2,6,1,3,5,7}
 * 解释：
 * 拥有最小高度的二叉搜索树
 *
 *          4
 *        /   \
 *       2     6
 *      / \    / \
 *     1   3  5   7
 * 注意事项
 * There may exist multiple valid solutions, return any of them.
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,4,5,6,7};
        TreeNode root = sortedArrayToBST(A);
        if(root==null){
            System.out.println("二叉搜索树为空");
        }
        // TODO 使用前序遍历的遍历方式
    }

    public static TreeNode sortedArrayToBST(int[] A) {

        // 1.先获取到中位数，作为根节点
        // 2.遍历中位数的左右，分别表示的是根节点的左右子节点
        if(A == null || A.length == 0){
            return null;
        }
        int start = 0;
        int end = A.length - 1;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = sorted(A, start, mid - 1);
        root.right = sorted(A, mid + 1, end);
        return root;
    }

    /**
     *
     * @param a
     * @param start
     * @param end
     */
    private static TreeNode sorted(int[] a, int start, int end) {
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(a[mid]);
        node.left = sorted(a,start,mid -1);
        node.right = sorted(a,mid + 1,end);
        return node;
    }
}