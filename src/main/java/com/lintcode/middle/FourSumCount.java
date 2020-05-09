package com.lintcode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * @author zhouwenchen
 * @date 20200506
 */
public class FourSumCount {

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;

        // 循环遍历A，B，将A，B中的和作为 map的key，value 为 key存在的个数
        for(int i = 0; i < A.length;i++){
            for (int j = 0; j < B.length; j++) {
                int sumAB = A[i] + B[j];
                if(map.containsKey(sumAB)){
                    map.put(sumAB,map.get(sumAB)+1);
                } else {
                    map.put(sumAB,1);
                }
            }
        }

        // 同理，循环遍历C，D，找到 CD的和作为key  与 A，B中的he作为map的key  的负数 进行比较
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sumCD = -(C[i] + D[j]);
                if(map.containsKey(sumCD)){
                    res += map.get(sumCD);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-2,-1};
        int[] C = new int[]{-1, 2};
        int[] D = new int[]{0, 2};
        int count = fourSumCount(A, B, C, D);
        System.out.println("four sum count is：" + count);
    }
}
