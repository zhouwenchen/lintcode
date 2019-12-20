package com.lintcode.middle;

import com.lintcode.node.ListNode;

/**
 * 1292. 奇偶链表
 * 中文English
 * 给定单链表，将所有奇数节点连接在一起，然后将偶数节点连接在一起。 请注意，这里我们讨论的是节点编号，而不是节点中的值。
 *
 * 样例
 * 样例1:
 *
 * 输入： 1->2->3->4->5->NULL
 * 输出： 1->3->5->2->4->NULL
 * 样例2:
 *
 * 输入： 2->1->null
 * 输出： 2->1->null
 * 注意事项
 * 奇数节点和偶数节点的相对位置应当不变。
 * 第一个节点应为奇数，第二个节点为偶数，以此类推……
 */
public class OddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //
        ListNode first = head;
        ListNode sencode = head.next;
        boolean flag = false; // 用于标识是偶数节点，还是奇数节点
        ListNode p1 = first;
        ListNode p2 = sencode;
        ListNode temp = null;  // 需要记录 p1 最后一个节点的值
        while (first != null && first.next != null){
            flag = false;
            sencode = first.next;
            first.next = sencode.next;
            temp = first; // 记录一个临时节点，标识奇数节点的最后一个节点的值，用于连接到偶数链表的首节点
            first = sencode.next;
            if(first != null){
                sencode.next = first.next;
                flag = true;
            }
        }
        if(!flag){
            temp.next = p2;
        } else {
            first.next = p2;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode root = oddEvenList(node1);
        while (root != null){
            System.out.print(root.val + " -> ");
            root = root.next;
        }
        System.out.print("null");
    }
}
