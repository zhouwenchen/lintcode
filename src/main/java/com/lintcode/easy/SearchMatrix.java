package com.lintcode.easy;

/**  
 * 
 * 28. 搜索二维矩阵
中文English
写出一个高效的算法来搜索 m × n矩阵中的值。

这个矩阵具有以下特性：

每行中的整数从左到右是排序的。
每行的第一个数大于上一行的最后一个整数。
样例
样例  1:
	输入: [[5]],2
	输出: false
	
	样例解释: 
  没有包含，返回false。

样例 2:
	输入:  
[
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
],3
	输出: true
	
	样例解释: 
	包含则返回true。

挑战
O(log(n) + log(m)) 时间复杂度
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class SearchMatrix {
	
    public static boolean searchMatrix(int[][] matrix, int target) {
    	for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[i].length; ++j){
            	if(matrix[i][j]> target){
            		return false;
            	} else if(matrix[i][j] < target){
            		continue;
            	} else if(matrix[i][j] == target){
            		return true;
            	}
            }
    	}
        return false;
    }
    
    public static void main(String[] args) {
    	int target = 10;
		int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		
		boolean b = searchMatrix(matrix , target);
		System.out.println(b);
	}
}
