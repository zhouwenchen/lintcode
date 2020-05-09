package com.lintcode.middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
*
* 184. 最大数
给出一组非负整数，重新排列他们的顺序把他们组成一个最大的整数。

样例
样例 1:

输入:[1, 20, 23, 4, 8]
输出:"8423201"
样例 2:

输入:[4, 6, 65]
输出:"6654"
挑战
在 O(nlogn) 的时间复杂度内完成。

注意事项
最后的结果可能很大，所以我们返回一个字符串来代替这个整数。
 * @Author zhouwenchen
 * @Date  20200506
 **/
public class LargestNumber {

    /**
     * 基于jdk1.8实现的方法
     *
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        String res = String.join("", Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((b, a) -> (a + b).compareTo(b + a))
                .toArray(String[]::new));
        //check all 0 case
        return res.charAt(0) == '0' ? "0" : res;
    }

    /**
     * 第三种解决方法
     * @param nums
     * @return
     */
    public static String largestNumber3(int[] nums) {
        StringBuilder res = new StringBuilder();
        Arrays.stream(nums).boxed().map(x -> x.toString()).sorted((x, y) -> (y + x).compareTo(x + y)).forEach(res::append);
        return res.charAt(0) == '0' ? "0" : res.toString();
    }

    public static String largestNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        // 将数组填充到集合中
        for (int i = 0; i < strs.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        // 自定义排序规则
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String result = sb.toString();
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if (index == result.length()) {
            return "0";
        }
        return result.substring(index);
    }

    public static void main(String[] args) {
        // 8423201
        int[] nums = new int[]{1, 20, 23, 4, 8};
        String result = largestNumber3(nums);
        System.out.println(result);
    }
}
