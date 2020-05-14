package com.lintcode.easy;

/**  
 * 82. 落单的数
给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。

样例
Example 1:

Input：[1,1,2,2,3,4,4]
Output：3
解释：
仅3出现一次
Example 2:

Input：[0,0,1]
Output：1
解释：
仅1出现一次
挑战
一次遍历，常数级的额外空间复杂度

注意事项
n≤100
 * @author zhouwenchen@021.com  
 * @date 2019年3月27日上午11:43:56   
 */
public class SingleNumber {
	
    public static int singleNumber(int[] A) {
    	if(A == null || A.length == 0){
    		return -1;
    	}
    	int res = 0;
		for(int i = 0; i < A.length;i++){
			res ^=A[i];
		}
    	
    	return res;
    }
    
    public static void main(String[] args) {
    	int[] A = new int[]{1,1,2,2,3,4,4};
		int result = singleNumber(A);
		System.out.println(result);
	}
}
