package com.lintcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**  
 * 22. 平面列表
给定一个列表，该列表中的每个元素要么是个列表，要么是整数。将其变成一个只包含整数的简单列表。

样例
样例  1:
	输入: [[1,1],2,[1,1]]
	输出:[1,1,2,1,1] 
	
	样例解释:
	将其变成一个只包含整数的简单列表。


样例 2:
	输入: [1,2,[1,2]]
	输出:[1,2,1,2]
	
	样例解释: 
	将其变成一个只包含整数的简单列表。
	
样例 3:
	输入:[4,[3,[2,[1]]]]
	输出:[4,3,2,1]
	
	样例解释: 
	将其变成一个只包含整数的简单列表。
	
挑战
请用非递归方法尝试解答这道题。

注意事项
如果给定的列表中的要素本身也是一个列表，那么它也可以包含列表。
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class Flatten {
	
    public static List<Integer> flatten(List<NestedInteger> nestedList) {
    	List<Integer> result = new ArrayList<Integer>();
    	for(int i = 0; i < nestedList.size();i++){
    		// 如果是整数，就添加到结果集
    		if(nestedList.get(i).isInteger()){
    			result.add(nestedList.get(i).getInteger());
    			continue;
    		}
    		// 是列表则递归调用结果全添加到结果集中
    		result.addAll(flatten(nestedList.get(i).getList()));
    	}
    	return result;
    }
    
    public static List<Integer> flatten2(List<NestedInteger> nestedList) {
    	List<Integer> result = new LinkedList<Integer>();
    	Stack<NestedInteger> stack = new Stack<NestedInteger>();
    	
    	// 初始全部入栈
    	nestedList.forEach(stack::push);
    	while(!stack.isEmpty()){
    		NestedInteger current = stack.pop();
    		if(current == null){
    			continue;
    		}
    		
    		// 如果结果是整数的话，添加到结果集中
    		if(current.isInteger()){
    			((LinkedList<Integer>) result).addFirst(current.getInteger());
    		} else{
    			current.getList().forEach(stack::push);
    		}
    	}
    	return result;
    }
}

interface NestedInteger {
	// @return true if this NestedInteger holds a single integer,
	// rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds,
	// if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds,
	// if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
 
