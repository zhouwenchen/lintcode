package com.lintcode.tree;

import com.lintcode.node.ParentTreeNode;

/**
 * 474. 最近公共祖先 II
 * 中文English
 * 给一棵二叉树和二叉树中的两个节点，找到这两个节点的最近公共祖先LCA。
 *
 * 两个节点的最近公共祖先，是指两个节点的所有父亲节点中（包括这两个节点），离这两个节点最近的公共的节点。
 *
 * 每个节点除了左右儿子指针以外，还包含一个父亲指针parent，指向自己的父亲。
 *
 * 样例
 * 样例 1:
 *
 * 输入：{4,3,7,#,#,5,6},3,5
 * 输出：4
 * 解释：
 *      4
 *      / \
 *     3   7
 *        / \
 *       5   6
 * LCA(3, 5) = 4
 * 样例 2:
 *
 * 输入：{4,3,7,#,#,5,6},5,6
 * 输出：7
 * 解释：
 *       4
 *      / \
 *     3   7
 *        / \
 *       5   6
 * LCA(5, 6) = 7
 */
public class LowestCommonAncestorII {

    /**
     * 如果A、B在两边找到的话，那么最大的公共祖先节点应该是root
     * 如果在在root的left找到的话，那么root的right肯定为null，那么A、B的最近的祖先节点应该是root.left 的一边
     *
     * TODO 这个居然可以通过，没有测试案例，但是思路通过递归的方式实现的
     * TODO 可以通过遍历root节点到目标节点的路径，然后获取两个路径的最大前缀的点，获取最大前缀的最后一个节点就是目标节点的最近公共祖先的节点
     *
     * @param root
     * @param A
     * @param B
     * @return
     */
    public static ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        if(root == null || root == A || root == B){
            return root;
        }

        ParentTreeNode left = lowestCommonAncestorII(root.left,A,B);
        ParentTreeNode right = lowestCommonAncestorII(root.right,A,B);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;
    }

}