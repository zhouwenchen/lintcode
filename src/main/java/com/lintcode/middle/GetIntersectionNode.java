package com.lintcode.middle;

import com.lintcode.node.ListNode;

import java.util.HashSet;
import java.util.Stack;

/**
 * 380. 两个链表的交叉
 * 中文English
 * 请写一个程序，找到两个单链表最开始的交叉节点。
 *
 * 样例
 * 样例 1：
 *
 * 输入：
 * 	A:          a1 → a2
 * 	                   ↘
 * 	                     c1 → c2 → c3
 * 	                   ↗
 * 	B:     b1 → b2 → b3
 * 输出：c1
 * 解释：在节点 c1 开始交叉。
 * 样例 2:
 *
 * 输入:
 * Intersected at 6
 * 1->2->3->4->5->6->7->8->9->10->11->12->13->null
 * 6->7->8->9->10->11->12->13->null
 * 输出: Intersected at 6
 * 解释：begin to intersect at node 6.
 * 挑战
 * 需满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 注意事项
 * 如果两个链表没有交叉，返回null。
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 */
public class GetIntersectionNode {
    /**
     * 思路1：循环遍历两个链表，进行比较 ，但是时间复杂度是o(n^2)
     * 思路2：
     *       2.1：如果 headA 和 headB 为空，那么直接返回
     *       2.2：如果有交叉的话，那么最后一个节点一定相同，从后往前遍历，如果遇到不相同的，那么上一个，就是交叉点（使用栈实现）
     *       2.3 TODO 目前阶段  超时
     * 思路3：
     *      3.1：使用Hash表的形式，由于是没有环的，所以可以保证hash的表中的值唯一
     *      3.2：先遍历链表A，将链表A 所有的元素加入到hash表中，然后遍历链表B，判断每一个链表是否已经在hash表中。如果已经存在的话，表示的是存在的节点，就是hash表交叉的节点
     * @param headA 链表A
     * @param headB 链表B
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1.判断其中是否有一个为空
        if(headA == null || headB == null){
            return null;
        }
        // 2.分别遍历链表，存入到redis中
        Stack<Integer> stack1 = new Stack<Integer>();
        ListNode p1 = headA;
        while (p1 != null){
            stack1.push(p1.val);
            p1 = p1.next;
        }

        Stack<Integer> stack2 = new Stack<>();
        ListNode p2 = headB;
        while (p2 != null){
            stack2.push(p2.val);
            p2 = p2.next;
        }

        // 遍历两个栈，找到第一个相等的情况
        ListNode result = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack1.peek() == stack2.peek()){
                result = new ListNode(stack1.peek());
                stack1.pop();
                stack2.pop();
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * 使用Hash表实现
     * 1. 先遍历链表A，存入到hashset中
     * 2.遍历链表B，判断链表B中的某一个节点是否存在于 hashset 中
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        // 1.先遍历链表A
        ListNode result = null;
        if(headA == null || headB == null){
            return result;
        }

        // 2. 遍历链表A，将其存入到 hashset 中
        ListNode p1 = headA;
        HashSet<ListNode> map = new HashSet<>();
        while(p1 != null){
            map.add(p1);
            p1 = p1.next;
        }

        // 3.遍历链表B，判断链表A中是否存在链表B中的节点
        ListNode p2 = headB;
        while (p2 != null){
            if(map.contains(p2)){
                return p2;
            }
            p2 = p2.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        ListNode node22 = new ListNode(22);
        ListNode node33 = new ListNode(33);
//        ListNode node44 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node22.next = node33;
//        node33.next = node44;
        node33.next = node4;
        ListNode root = getIntersectionNode1(node1, node22);
        while (root != null){
            System.out.print(root.val +" -> ");
            root = root.next;
        }
        System.out.print("null");
    }
}
