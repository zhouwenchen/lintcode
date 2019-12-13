package com.lintcode.middle;

import com.lintcode.node.ListNode;

/**
 * 99. 重排链表
 * 中文English
 * 给定一个单链表L: L0→L1→…→Ln-1→Ln,
 *
 * 重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 必须在不改变节点值的情况下进行原地操作。
 *
 * 样例
 * 样例 1:
 * 	输入: 1->2->3->4->null
 * 	输出: 1->4->2->3->null
 *
 * 样例 2:
 * 	输入: 1->2->3->4->5->null
 * 	输出: 1->5->2->4->3->null
 *
 * 挑战
 * 你能在不改变节点值的情况下原地完成吗？
 */
public class ReorderList {
    //1.先计算链表的长度
    //2。分成两个链表A、B
    //3.将链表B翻转，得到链表C
    //4.遍历链表A的同时，将翻转后的链表C 进行遍历
    public static ListNode reorderList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 1.先计算链表的长度
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        // 2.分成两个链表A、B
        int mid = len / 2 ;
        ListNode A = head;
        ListNode B = null;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        for(int i = 0; i < mid; i++){
            pre = pre.next;
        }
        B = pre.next;
        pre.next = null; // 使得链表A 到pre为止

        // 3.将链表B翻转
        ListNode sencode = null;
        ListNode first = B;
        ListNode C = null;// 定义一个临时的节点值
        while(first !=null){
            sencode = first.next;
            first.next = C;
            C = first;
            first = sencode;
        }
        // C 节点就是链表B翻转后的头结点信息

        // 4.遍历链表A的同时，将链表B的值，插入到链表A中
        first = A;
        ListNode cfirst = C;
        ListNode csecode = null;
        ListNode preNode = null;
        while(first !=null){
            preNode = first;
            sencode = first.next;
            csecode = cfirst.next;
            first.next = cfirst;
            // 保证链表A已经遍历结束的情况下，链表C 最后一个节点的情况
            if(sencode != null){
                cfirst.next = sencode;
            }
            first = sencode;
            cfirst = csecode;
        }
        return A;
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
//        node4.next = node5;

//        ListNode node0 = new ListNode(0);

        ListNode resultListNode = reorderList(node1);
//        ListNode resultListNode = reorderList(node0);
        while(resultListNode != null){
            System.out.print(resultListNode.val + " -> ");
            resultListNode = resultListNode.next;
        }
        System.out.print("null");
    }
}
