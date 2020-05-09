package com.lintcode.middle;

import java.util.*;

/**
 * 182. 删除数字
 * 中文English
 * 给出一个字符串 A, 表示一个 n 位正整数, 删除其中 k 位数字, 使得剩余的数字仍然按照原来的顺序排列产生一个新的正整数。
 * <p>
 * 找到删除 k 个数字之后的最小正整数。
 * <p>
 * N <= 240, k <= N
 * <p>
 * 样例
 * 样例 1：
 * <p>
 * 输入: A = "178542", k = 4
 * 输出:"12"
 * 样例 2：
 * <p>
 * 输入: A = "568431", k = 3
 * 输出:"431"
 *
 * @Author zhouwenchen
 * @Date 20200507
 **/
public class DeleteDigits {

    /**
     * 先数组排序，并将数据存入到map中，数组中的值为key，索引为 value
     * 删除最大的k个元素，剩下的，根据数组
     * TODO 没有考虑到最后结果的顺序问题
     *
     * @param A
     * @param k
     * @return
     */
    public static String DeleteDigits(String A, int k) {
        String[] arr = A.split("");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // key作为key，索引作为 value
            map.put(Integer.parseInt(arr[i]), i);
        }
        // 将map进行排序 TODO 以下解法，没有考虑到顺序的问题，删除最大的值，并不一定保证最后的结果是最小的
        StringBuilder sb = new StringBuilder();
        map.entrySet().stream()/*reduce((Map.Entry<Integer, Integer> x,Map.Entry<Integer, Integer> y)-> Integer.valueOf(x.getKey() + "") > Integer.valueOf(y.getKey() + "")?x:y)*/
                .sorted(Map.Entry.comparingByKey())
                .limit(arr.length - k)
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sb.append(x.getKey()));
        return sb.toString().substring(0, 1).equals("0") ? sb.toString().substring(1) : sb.toString();
    }

    /**
     * 使用双层for循环，需要判断当前的值，是否大于下一个值，如果大于，可以删除。这是优先删除的元素
     *
     * @param A
     * @param k
     * @return
     */
    public static String DeleteDigits2(String A, int k) {
        StringBuffer sb = new StringBuffer(A);
        int i, j;
        for (i = 0; i < k; i++) {
            for (j = 0; j < sb.length() - 1 && sb.charAt(j) <= sb.charAt(j + 1); j++) {
                continue;
            }
            sb.delete(j, j + 1);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        return sb.toString();
    }

    /**
     * 世成测试的额案例
     *
     * @param a
     * @param count
     * @return
     */
    public static List<Character> test2(List<Character> a, int count) {
        if (count == 0) {
            return a;
        } else {
            Character index = null;
            for (int i = 0; i < a.size() - 1; i++) {
                if (a.get(i + 1) < a.get(i)) {
                    count--;
                    index = a.get(i);
                    a.remove(index);
                    return test2(a, count);
                }
            }
        }
        return a;
    }


    public static void main(String[] args) {
//        String result = DeleteDigits("178542", 4);
//        String result = DeleteDigits("568431", 3);
//        String result = DeleteDigits("90249", 2);
        // TODO 第一个测试案例，这个是通不过的
//        String result = DeleteDigits("254193", 1);

//        String param = "178542";
//        List <Character> a = new ArrayList<>();
//        for (char c : param.toCharArray()) {
//            a.add(c);
//        }
//        List <Character> result = test2(a, 1);
//        System.out.println(result);
    }
}
