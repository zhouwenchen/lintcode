package com.lintcode.easy;

/**
 * 83. 落单的数 II
 * 中文English
 * 给出3*n + 1 个非负整数，除其中一个数字之外其他每个数字均出现三次，找到这个数字。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入:  [1,1,2,3,3,3,2,2,4,1]
 * 输出:  4
 * 样例 2:
 * <p>
 * 输入: [2,1,2,2]
 * 输出:  1
 * 挑战
 * 一次遍历，常数级的额外空间复杂度
 *
 * @Author zhouwenchen
 * @Date 20200512
 **/
public class SingleNumberII {

    /**
     * 使用位运算实现的操作
     * @param A
     * @return
     */
    public static int singleNumberII(int[] A) {
        if(A==null || A.length==0){
            return -1;
        }
        int result = 0;
        int[] bits = new int[32];
        for(int i = 0; i < 32;i++){
            for (int j = 0; j < A.length; j++) {
                bits[i] += A[j] >> i & 1;
                bits[i] %= 3;
            }
            result |=(bits[i] << i);
        }
        return result;
    }

    /**
     * TODO 一脸懵逼的解决方案
     * @param A
     * @return
     */
    public static int singleNumberII2(int[] A) {
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < A.length; i++) {
            ones = (ones ^ A[i]) & (~ twos);
            twos = (twos ^ A[i]) & (~ ones);
        }
        return ones;
    }

    public static void main(String[] args) {
        int result = singleNumberII2(new int[]{1, 1, 2, 3, 3, 3, 2, 2, 1,4});
        System.out.println(result);

        System.out.println();
    }
}
