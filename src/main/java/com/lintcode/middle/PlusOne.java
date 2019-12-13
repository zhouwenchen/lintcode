package com.lintcode.middle;

import com.lintcode.node.ListNode;

import java.util.Stack;

/**
 * 904. 加一链表
 * 中文English
 * 给定一个非负整数，这个整数表示为一个非空的单链表，每个节点表示这个整数的一位。返回这个整数加一。
 *
 * 除了0本身，所有数字在最高位前都没有0。
 *
 * 列表的头节点存的是这个整数的最高位。
 *
 * 样例
 * 样例1
 *
 * 输入: 1 -> 2 -> 3 -> null
 * 输出: 1 -> 2 -> 4 -> null
 * 解释:
 * 123 + 1 = 124
 * 样例2
 *
 * 输入: 9 -> 9 -> null
 * 输出: 1 -> 0 -> 0 -> null
 * 解释:
 * 99 + 1 = 100
 */
public class PlusOne {
    /**
     * 1. 先翻转链表
     * 2. 再加1操作
     * @param head 链表的头结点的值
     * @return 结果链表
     */
    public static ListNode plusOne(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
        // 1.先翻转链表
        ListNode first = head;
        ListNode sencode = null;
        ListNode reverseNode = null; // 接收临时变量
        while(first != null){
            sencode = first.next;
            first.next = reverseNode;
            reverseNode = first;
            first = sencode;
        }
        // 将翻转链表中的数据添加到 stack1 中，并加1操作
        Stack<Integer> stack = new Stack<>();
        int flag = 0; // 表示进位
        boolean isPlusOne = true;
        while (reverseNode !=null){
            int temp = 0;
            if(isPlusOne){
                temp += 1;
                isPlusOne = false;
            }
            temp += reverseNode.val + flag;
            flag = 0;
            if(temp >= 10){
                flag = 1;
            }
            stack.push(temp%10);
            reverseNode = reverseNode.next;
        }
        // 判断最后一个是否有进位
        if(flag == 1){
            stack.push(flag);
        }
        // 遍历栈，重新生成链表
        ListNode plusNode = new ListNode(0);
        first = new ListNode(stack.pop());
        plusNode.next = first;
        while (!stack.isEmpty()){
            ListNode temp = new ListNode(stack.pop());
            first.next = temp;
            first = temp;
        }

        return plusNode.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode reverNode = new ListNode(0);

        return reverNode.next;
    }

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);

//        node1.next = node2;
//        node2.next = node3;

        ListNode node1 = new ListNode(8);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;

        ListNode resutListNode = plusOne(node1);
        while (resutListNode != null){
            System.out.print(resutListNode.val +" -> ");
            resutListNode = resutListNode.next;
        }
        System.out.print("null");
    }
}

