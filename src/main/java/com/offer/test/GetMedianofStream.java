package com.offer.test;

import java.util.PriorityQueue;

/**  
 * 
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值
 * @author zhouwenchen@021.com  
 * @date 2019年7月9日 下午2:28:21 
 */
public class GetMedianofStream {
	
	private static PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
	private static PriorityQueue<Integer> maxheap = new PriorityQueue<>(15, (o1, o2) -> {
		return o2.compareTo(o1);
	});
	private static int count = 0;
	
	public static void Insert(Integer num){
		count++;
		// 当数据是奇数时，先进入最大堆，然后最大堆的最大值，进入最小堆里面
		if((count & 0x01) ==1){
			maxheap.add(num);
			minheap.add(maxheap.poll());
		} else {
			// 当数据是偶数是，先进入最小堆，然后最小堆的最小值，进入最大堆里面
			minheap.add(num);
			maxheap.add(minheap.poll());
		}
	}
	
	public static Double getMedianofStream(){
		if((count & 0x01) ==0){
			return  new Double((minheap.peek() + maxheap.peek())) / 2;
		} else {
			return new Double(minheap.peek());
		}
		
	}
	
	public static void main(String[] args) {
		Integer[] nums = new Integer[]{2,3,4,1,5,7,6,8};
		for(Integer num: nums){
			Insert(num);
		}
		double mid = getMedianofStream();
		System.out.println(mid);
		
//		minheap.add(2);
//		minheap.add(1);
//		minheap.add(3);
//		minheap.add(5);
//		minheap.add(4);
//		
//		maxheap.add(2);
//		maxheap.add(1);
//		maxheap.add(3);
//		maxheap.add(5);
//		maxheap.add(4);
		
		
		
	}
}
