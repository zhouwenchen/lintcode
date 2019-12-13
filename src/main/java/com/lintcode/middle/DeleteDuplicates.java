package com.lintcode.middle;

import com.lintcode.node.ListNode;

/**
 * 113. 删除排序链表中的重复数字 II
 * 中文English
 * 给定一个排序链表，删除所有重复的元素只留下原链表中没有重复的元素。
 *
 * 样例
 * 样例 1
 *
 * 输入 : 1->2->3->3->4->4->5->null
 * 输出 : 1->2->5->null
 * 样例 2
 *
 * 输入 : 1->1->1->2->3->null
 * 输出 : 2->3->null
 */
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = root;
        ListNode cur = head;
        while (cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                // 循环遍历，如果有多个的情况下
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;// 删除当前的节点
                }
                pre.next = cur.next; // 当前节点的前驱节点指向当前节点的下一个节点，标识删除当前节点
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node33 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node44 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node33;
        node33.next = node4;
        node4.next = node44;
        node44.next = node5;

        ListNode root = deleteDuplicates(node1);
       while (root != null){
           System.out.print(root.val +" -> ");
           root = root.next;
       }
        System.out.print("null");
    }
}
