package com.lintcode.middle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 48. 主元素 III
 * 中文English
 * 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k。
 *
 * 样例
 * 例1:
 *
 * 输入: [3,1,2,3,2,3,3,4,4,4] and k=3,
 * 输出: 3.
 * 例2:
 *
 * 输入: [1,1,2] and k=3,
 * 输出: 1.
 * 挑战
 * 要求时间复杂度为O(n)，空间复杂度为O(k)
 *
 * 注意事项
 * 数组中只有唯一的主元素
 */
public class MajorityNumber {
//    public static int majorityNumber(List<Integer> nums, int k) {
//        Map<Integer,Integer> map = new HashMap<>();
//        Optional<Integer> collect = nums.stream().map(o -> {
//                    Integer integer = map.get(o) == null ? map.put(o, 1) : map.put(o, map.get(o) + 1);
//                    int max = map.get(o);
//                    return o;
//                }
//        ).collect(Collectors.maxBy((o1, o2) -> map.get(o1).compareTo(map.get(o2))));
//        // 遍历获取主元素
//
//        return collect.get();
//    }

        public static int majorityNumber(List<Integer> nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            for(Integer num: nums){
                if(map.get(num) == null){
                    map.put(num,1);
                }else {
                    map.put(num,map.get(num)+1);
                }
            }
            int des = nums.size() / k;
            Set<Integer> keySet = map.keySet();
            Integer temp = 0;
            for(Integer key:keySet){
                Integer count = map.get(key);
                if(count>des){
                    temp = key;
                    break;
                }
            }
            return temp;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3,1,2,3,2,3,3,4,4,4);
        int number = majorityNumber(nums, 3);
        System.out.println("数组中只有唯一的主元素:\t"+number);
    }
}
