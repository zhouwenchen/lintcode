package com.lintcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 50. 数组剔除元素后的乘积
 * 中文English
 * 给定一个整数数组A。
 * 定义B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]， 计算B的时候请不要使用除法。请输出B。
 * <p>
 * 样例
 * 样例 1
 * <p>
 * 输入: A = [1, 2, 3]
 * 输出: [6, 3, 2]
 * 解析：B[0] = A[1] * A[2] = 6; B[1] = A[0] * A[2] = 3; B[2] = A[0] * A[1] = 2
 * 样例 2
 * <p>
 * 输入: A = [2, 4, 6]
 * 输出: [24, 12, 8]
 *
 * @Author zhouwenchen
 * @Date 20200511
 **/
public class ProductExcludeItself {

    /**
     * 使用了双层For循环，效率比较低
     *
     * @param nums
     * @return
     */
    public static List<Long> productExcludeItself(List<Integer> nums) {
        List<Long> numB = new ArrayList<Long>();
        for (int i = 0; i < nums.size(); i++) {
            long sum = 1;
            for (int j = 0; j < nums.size(); j++) {
                if (j != i) {
                    sum *= nums.get(j);
                }
            }
            numB.add(sum);
        }
        return numB;
    }

    /**
     * @param nums
     * @return
     */
    public static List<Long> productExcludeItself2(List<Integer> nums) {
        List<Long> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        long product = 1;
        result.add(product);

        int len = nums.size();
        for (int i = 1; i < len; i++) {
            product *= nums.get(i-1);
            result.add(product);
        }
        product = 1;
        for (int i = len - 2; i >= 0; i--) {
            product *= nums.get(i + 1);
            result.set(i, result.get(i) * product);
        }
        return result;
    }

    public static void main(String[] args) {
        productExcludeItself2(Arrays.asList(1, 2, 3)).stream().forEach(System.out::print);
    }
}
