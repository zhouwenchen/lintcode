package com.offer.test;

import java.util.ArrayDeque;

import com.lintcode.node.InternalData;

/**  
 * 队列的最大值
 * 请定义一个队列并实现函数max得到队列里的最大值，要求函数max、push_back、pop_front的时间复杂度都是O（1）
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年7月19日 上午10:13:15 
 */
public class MaxInWindows2 {
	private static ArrayDeque<InternalData> data = new ArrayDeque<InternalData>();
	private static ArrayDeque<InternalData> maximum = new ArrayDeque<InternalData>();
	
	private static int curIndex;
	
	/**
	 * 出队列
	 */
	public static void pop_front(){
		if(data.isEmpty()){
			System.out.println("队列为空");
			return;
		}
		InternalData curData = data.removeFirst();
		if(curData.index == maximum.getFirst().index){
			maximum.removeFirst();
		}
	}
	
	/**
	 * 获取队列中的最大值
	 * @return
	 */
	public static int max() {
		if (maximum == null) {
			System.out.println("queue 为空");
			return 0;
		}

		return maximum.getFirst().number;
	}
	
	/**
	 * 
	 * @param number
	 */
	public static void push_back(int number) {
		InternalData curData = new InternalData(number, curIndex);
		data.addLast(curData);

		while (!maximum.isEmpty() && maximum.getLast().number < number) {
			maximum.removeLast();
		}

		maximum.addLast(curData);
		curIndex++;
	}
	
	public static void main(String[] args) {
		push_back(2);
		System.out.println(max());

		push_back(3);
		// {2,3}
		System.out.println(max());

		pop_front();
		System.out.println(max());
	}
}
