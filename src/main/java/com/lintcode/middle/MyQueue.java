package com.lintcode.middle;

import java.util.Stack;

/**
 * 40. 用栈实现队列
 * 中文English
 * 正如标题所述，你需要使用两个栈来实现队列的一些操作。
 *
 * 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
 *
 * pop和top方法都应该返回第一个元素的值。
 *
 * 样例
 * 例1:
 *
 * 输入:
 *     push(1)
 *     pop()
 *     push(2)
 *     push(3)
 *     top()
 *     pop()
 * 输出:
 *     1
 *     2
 *     2
 * 例2:
 *
 * 输入:
 *     push(1)
 *     push(2)
 *     push(2)
 *     push(3)
 *     push(4)
 *     push(5)
 *     push(6)
 *     push(7)
 *     push(1)
 * 输出:
 * []
 * 挑战
 * 仅使用两个栈来实现它，不使用任何其他数据结构，push，pop 和 top的复杂度都应该是均摊O(1)的
 *
 * 注意事项
 * 假设调用pop()函数的时候，队列非空
 */
public class MyQueue {
    private static Stack<Integer> stack1 = new Stack();
    private static Stack<Integer> stack2 = new Stack();

    /**
     * 1.定义两个栈，其中stack1 仅仅做入栈操作，stack2，仅仅做出栈操作，
     * 2.在队列出队列的操作，对应的是stack2出栈 ，如果stack2为空的情况下，需要先将stack1中的数据全部出栈到 stack2 中
     */
    public MyQueue() {}

    public static void push(int element) {
        stack1.push(element);
    }

    public static int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static int top() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        push(1);
        System.out.println(pop());
        push(2);
        push(3);
        System.out.println(top());
        System.out.println(pop());
    }
}
