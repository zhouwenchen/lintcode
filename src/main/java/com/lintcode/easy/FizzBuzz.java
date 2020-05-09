package com.lintcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 描述
 中文
 English
 给你一个整数n. 从 1 到 n 按照下面的规则打印每个数：

 如果这个数被3整除，打印fizz.
 如果这个数被5整除，打印buzz.
 如果这个数能同时被3和5整除，打印fizz buzz.
 如果这个数既不能被 3 整除也不能被 5 整除，打印数字本身。
 * @Author zhouwenchen
 * @Date 20200507
 **/
public class FizzBuzz {

    /**
     * 三元表达式
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            result.add(i%3==0?(i%5==0?"fizz buzz":"fizz"):(i%5==0?"buzz":(i+"")));
        }
        return result;
    }

    /**
     * 只使用哦一个if语句实现
     * @param n
     */
    public static List<String> fizzBuzz2(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 1; i <= n;i++){
            if(i % 15 == 0){
                result.add("fizz buzz");
            }else if(i % 5 == 0){
                result.add("buzz");
            } else if(i % 3 == 0){
                result.add("fizz");
            }else {
                result.add(i+"");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = fizzBuzz(13);
        System.out.println(result);
        List<String> result1 = fizzBuzz2(13);
        System.out.println(result1);
    }
}
