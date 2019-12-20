package com.lintcode.middle;

import com.lintcode.node.ListNode;

/**
 * 511. 交换链表当中两个节点
 * 中文English
 * 给你一个链表以及两个权值v1和v2，交换链表中权值为v1和v2的这两个节点。保证链表中节点权值各不相同，如果没有找到对应节点，那么什么也不用做。
 *
 * 样例
 * 样例 1:
 *
 * 输入: 1->2->3->4->null, v1 = 2, v2 = 4
 * 输出: 1->4->3->2->null
 * 样例 2:
 *
 * 输入: 1->null, v1 = 2, v2 = 1
 * 输出: 1->null
 * 注意事项
 * 你需要交换两个节点而不是仅仅交换节点的权值
 */
public class SwapNodes {

    /**
     * 思路1：先找到两个节点的值在链表中的位置。
     *     1.1 两个节点是否相邻
     *     1.2 两个节点不相邻
     *
     * // TODO 需要考虑的东西过多
     */
    public static ListNode swapNodes(ListNode head, int v1, int v2) {
        // 1.需要判断v1 和 v2 是否在链表中
        ListNode dummy = new ListNode(0); // 定义一个临时节点
        dummy.next = head;
        ListNode cur = dummy;
        ListNode node1Prev = null;
        ListNode node2Prev = null;
        while (cur.next != null){
            if(cur.next.val == v1){
                node1Prev = cur;
            } else if(cur.next.val == v2){
                node2Prev = cur;
            }
            cur = cur.next;
        }

        // 如果v1 和 v2 有一个值不存子啊的话，那么直接返回，我们通过判断 v1 和 v2 的前缀的节点
        if(node1Prev == null || node2Prev == null){
            return head;
        }

        if(node2Prev.next == node1Prev){ // 为了确保 node1Prev 一定是 在 node2Prev 的前面，如果不是的话，那么就替换过来
            // make sure node2Prev.next is not node1Prev
            ListNode t = node1Prev;
            node1Prev = node2Prev;
            node2Prev = t;
        }

        ListNode node1 = node1Prev.next;
        ListNode node2 = node2Prev.next;
        ListNode node2Next = node2.next;

        if(node1Prev.next == node2Prev){ // 表示的是相邻的节点
            node1Prev.next = node2;
            node2.next = node1;
            node1.next = node2Next;
        } else {
            node1Prev.next = node2;
            node2.next = node1.next;

            node2Prev.next = node1;
            node1.next = node2Next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

//        ListNode root = swapNodes(node1, 2, 4);
//        ListNode root = swapNodes(node1, 2, 3);
        ListNode root = swapNodes(node1, 3, 2);
        while (root != null){
            System.out.print(root.val + " -> ");
            root = root.next;
        }
        System.out.println("null");
    }
}
