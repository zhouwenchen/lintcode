package com.lintcode.tree;

import com.lintcode.node.ListNode;
import com.lintcode.node.TreeNode;

import javax.management.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 242. 将二叉树按照层级转化为链表
 * 中文English
 * 给一棵二叉树，设计一个算法为每一层的节点建立一个链表。也就是说，如果一棵二叉树有 D 层，那么你需要创建 D 条链表。
 *
 * 样例
 * 样例 1:
 *
 * 输入: {1,2,3,4}
 * 输出: [1->null,2->3->null,4->null]
 * 解释:
 *         1
 *        / \
 *       2   3
 *      /
 *     4
 * 样例 2:
 *
 * 输入: {1,#,2,3}
 * 输出: [1->null,2->null,3->null]
 * 解释:
 *     1
 *      \
 *       2
 *      /
 *     3
 */
public class BinaryTreeToLists {

    /**
     * 思路就是  二叉树的  层序遍历 的实现
     * @param root 二叉树的根节点
     * @return 返回链表的集合
     */
    private static List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result = new ArrayList<>();
        if(root == null){
            return  result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 定义两个变量
        ListNode dumy = new ListNode(0);
//        ListNode lastNode = null;

        // 遍历队列
        while(!queue.isEmpty()){
            dumy.next = null;
            ListNode lastNode = dumy;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                lastNode.next = new ListNode(head.val);
                lastNode = lastNode.next;
                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            result.add(dumy.next);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        List<ListNode> resultListNode = binaryTreeToLists(node1);
        resultListNode.stream().forEach(o->{
            while (o != null){
                System.out.print(o.val+" ->");
                o = o.next;
            }
            System.out.print(" null");
            System.out.println();
        });
    }
}
