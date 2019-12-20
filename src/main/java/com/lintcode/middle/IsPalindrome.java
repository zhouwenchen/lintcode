package com.lintcode.middle;

import com.fasterxml.jackson.databind.util.LinkedNode;
import com.lintcode.node.ListNode;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Stack;

/**
 *223. 回文链表
 * 中文English
 * 设计一种方式检查一个链表是否为回文链表。
 *
 * 样例
 * 样例 1:
 *
 * 输入: 1->2->1
 * 输出: true
 * 样例 2:
 *
 * 输入: 2->2->1
 * 输出: false
 * 挑战
 * O(n)的时间和O(1)的额外空间。
 */
public class IsPalindrome {
    /**
     * 思路 1.先判断链表的长度，然后遍历链表，链表的前半部分先入栈，出栈进行比较
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        // 1. 获取到链表的长度
        int len = 0;
        ListNode p = head;
        while (p != null){
            len++;
            p = p.next;
        }
        // 2. 先一半的链表节点入栈
        boolean flag = len % 2 == 0; // falg (true):表示链表长度是偶数，false：表示链表的长度是奇数
        int mid = len / 2 ;
        Stack<Integer> stack = new Stack<>();
        p = head;
        for(int i = 0; i < mid; i++){
            stack.push(p.val);
            p = p.next;
        }
        // 奇数的话，遍历链表，和栈中的元素出战
        if(!flag){
            p = p.next;
        }
        while(p != null && !stack.isEmpty()){
            // 如果是奇数的话，链表中的第一个值需要剔除
            if(!stack.peek().equals(p.val)){
                return false;
            }
            stack.pop();
            p = p.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
//        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        boolean result = isPalindrome(node1);
        System.out.println("是否是回文链表：\t" + result);
    }
}
