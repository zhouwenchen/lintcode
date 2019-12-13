package com.lintcode.middle;

import com.lintcode.node.ListNode;

import java.util.Stack;

/**
 * 221. 链表求和 II
 * 中文English
 * 假定用链表表示两个数，其中每个节点仅包含一个数字。假设这两个数的数字顺序排列，请设计一种方法将两个数相加，并将其结果表现为链表的形式。
 *
 * 样例
 * 样例 1:
 *
 * 输入: 6->1->7   2->9->5
 * 输出: 9->1->2
 * 样例 2:
 *
 * 输入: 1->2->3   4->5->6
 * 输出: 5->7->9
 */
public class AddLists2 {
    /**
     *  1.遍历链表1 和链表 2 ，并将其存入到站中stack1 和  stack2 中
     *      1.1.每次弹出栈中的一个元素相加，如果超过10 就进位1
     *  2.翻转链表A 和 B，将翻转后的链表，遍历求和，将得到的结果链表，再次翻转得到目标链表的值 TODO
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return
     */
    public static ListNode addLists2(ListNode l1, ListNode l2) {
        // l1 或者 l2 为空的情况
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l1 != null && l2 == null){
            return l1;
        }
        // TODO 进位的问题
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        // 2.每次从两个栈中弹出元素的值,默认 stack1 中的元素不小于 stack2 中的元素的个数
        int flag = 0;
        Stack<Integer> stack3 = new Stack<>();
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            Integer v1 = stack1.pop();
            Integer v2 = stack2.pop();
            Integer temp = v1 + v2 + flag;
            flag = putstack(stack3, temp);
        }
        // TODO 某一个statck1 或者 stack2 不为空 ，而且此时有进位产生

        // 需要考虑其中某一个stack1 或者  stack2 中长度不一致的问题
        while (!stack1.isEmpty()){
            int temp = stack1.pop() + flag;
            flag = putstack(stack3, temp);
        }
        while (!stack2.isEmpty()){
            int temp = stack2.pop() + flag;
            flag = putstack(stack3, temp);
        }
        if(flag==1){
            stack3.push(flag);
        }
        // 3. 需要将栈中保存的值，重新生成链表
        ListNode root = new ListNode(0);
        ListNode pre = root;
        while(!stack3.isEmpty()){
            ListNode node = new ListNode(stack3.pop());
            pre.next = node;
            pre = node;
        }
        return root.next;
    }

    private static int putstack(Stack<Integer> stack3, int temp) {
        int flag;
        if (temp >= 10) {
            // 获取余数和进位
            temp = temp % 10;
            flag = 1;
        } else {
            flag = 0;
        }
        stack3.push(temp);
        return flag;
    }

    public static void main(String[] args) {
        ListNode node6 = new ListNode(6);
        ListNode node1 = new ListNode(1);
        ListNode node7 = new ListNode(7);

        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node9 = new ListNode(9);
        ListNode node5 = new ListNode(5);

        node6.next = node1;
        node1.next = node7;

        node3.next = node2;
        node2.next = node9;
        node9.next = node5;

        ListNode resutListNode = addLists2(node6, node3);
        while (resutListNode != null){
            System.out.print(resutListNode.val +" -> ");
            resutListNode = resutListNode.next;
        }
        System.out.print("null");
    }
}

