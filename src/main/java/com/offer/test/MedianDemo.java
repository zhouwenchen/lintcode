package com.offer.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**  
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 
 * 用两个堆保存数据，保证两个堆的数据保持平衡（元素个数相差不超过1）大顶堆存放的数据要比小顶堆的数据小当两个堆中元素为偶数个，将新加入元素加入到大顶堆，
 * 如果要加入的数据，比小顶堆的最小元素大，先将该元素插入小顶堆，然后将小顶堆的最小元素插入到大顶堆。
 * 当两个堆中元素为奇数个，将新加入元素加入到小顶堆，如果要加入的数据，比大顶堆的最大元素小，先将该元素插入大顶堆，然后将大顶堆的最大元素插入到小顶堆
 * 
 * @author zhouwenchen@021.com  
 * @date 2019年6月25日 下午2:16:10 
 */
public class MedianDemo {
	
	/**
	 * 数据排序，根据数据的奇偶性判断中位数的值
	 * @param nums
	 * @return
	 */
	public static double median(int[] nums){
		double median = 0;
		if(nums == null || nums.length == 0){
			return median;
		}
		// 排序
		List<Integer> lists = new ArrayList<Integer>();
		for (Integer num : nums) {
			lists.add(num);
		}
		Integer[] arrs = lists.toArray(new Integer[lists.size()]);
		Arrays.sort(arrs);
		if(arrs.length % 2 == 1){
			median = arrs[arrs.length>>1];
		} else {
			median = (arrs[(arrs.length>>1) -1] + arrs[arrs.length>>1])/2.0;
		}
		return median;
	}
	
	private static int count = 0;
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>(11, (o1, o2) -> {return o2.compareTo(o1);});
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
	
	/**
	 * 使用两个堆来实现的，最大堆和最小堆
	 * 最大堆种的根节点是最小值
	 * 最小堆中的根节点是最大值
	 * 特点：其中最大堆中的根节点的最小值     大于   最小堆中的根节点中的最大值   
	 * 
	 * @param nums
	 * @return
	 */
	public static double median2(int[] nums) {
		double median = 0.0;
		if (nums == null || nums.length == 0) {
			return median;
		}
		for (int num : nums) {
			count++;
			if (count % 2 == 1) { // 偶数
				maxHeap.add(num);
				Integer temp = maxHeap.poll();
				minHeap.add(temp);
			} else {// 奇数
				minHeap.add(num);
				Integer temp = minHeap.poll();
				maxHeap.add(temp);
			}
		}

		// 获取到中位数
		if (count % 2 == 0) {
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			return minHeap.peek();
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] { 2, 1, 3, 6, 4, 5, 7, 8, 9, 10 };
		double median = median2(nums);
		System.out.println(median);
	}
}
