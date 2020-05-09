package com.lintcode.middle;

import java.util.LinkedList;

/**
 * 12. 带最小值操作的栈
 * 中文English
 * 实现一个栈, 支持以下操作:
 *
 * push(val) 将 val 压入栈
 * pop() 将栈顶元素弹出, 并返回这个弹出的元素
 * min() 返回栈中元素的最小值
 * 要求 O(1) 开销.
 *
 * 样例
 * 样例 2:
 *
 * 输入:
 *   push(1)
 *   min()
 *   push(2)
 *   min()
 *   push(3)
 *   min()
 * 输出:
 *   1
 *   1
 *   1
 * 注意事项
 * 保证栈中没有数字时不会调用 min()
 */
public class MinStack {

    /**
     * 思路：定义两个栈，一个是 datastack，另个是记录栈中最小值的  minstack
     */
    private LinkedList<Integer> dataStack = new LinkedList();
    private LinkedList<Integer> minStack = new LinkedList();
    public MinStack() {}

    /**
     * 需要将最小值放置在栈顶的位置
     * @param number
     */
    public void push(int number) {
        dataStack.addFirst(number);
        if(minStack.isEmpty()|| number <= minStack.getFirst()){
            minStack.addFirst(number);
        }
    }

    /**
     * 弹出栈顶的元素之
     * @return
     */
    public int pop() {
        int data = 0;
        if(!dataStack.isEmpty()){
            data = dataStack.removeFirst();
            if(data == minStack.getFirst()){
                minStack.removeFirst();
            }
        }
        return data;
    }

    /**
     * @return: An integer
     */
    public int min() {
        if(!dataStack.isEmpty()){
            return minStack.getFirst();
        }
        return 0;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        int pop = stack.pop();
        System.err.println(pop);

        stack.push(2);
        stack.push(3);
        int min = stack.min();
        System.err.println(min);

        stack.push(1);
        int min1 = stack.min();
        System.err.println(min1);
        System.out.println("弹出栈中的元素数据 ===== ");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
