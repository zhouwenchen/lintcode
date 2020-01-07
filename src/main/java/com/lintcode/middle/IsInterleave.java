package com.lintcode.middle;

/**
 * 29. 交叉字符串
 * 中文English
 * 给出三个字符串:s1、s2、s3，判断s3是否由s1和s2交叉构成。
 *
 * 样例
 * 样例 1：
 *
 * 输入:
 * "aabcc"
 * "dbbca"
 * "aadbbcbcac"
 * 输出:
 * true
 * 样例 2：
 *
 * 输入:
 * ""
 * ""
 * "1"
 * 输出:
 * false
 * 样例 3：
 *
 * 输入:
 * "aabcc"
 * "dbbca"
 * "aadbbbaccc"
 * 输出:
 * false
 * 挑战
 * 要求时间复杂度为O(n2)或者更好
 *
 * TODO 未解决的算法
 */
public class IsInterleave {
    /**
     * 1.先判断长度是否满足
     *
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
//        if(s1.length()==0 && s2.equals(s3)|| s2.length() == 0 && s1.equals(s3)){
//            return true;
//        }

        boolean interleaved[][] = new boolean[len1 + 1][len2 + 1];
        interleaved[0][0] = true;

        for(int i = 1; i <= len1; i++){
            if(s3.charAt(i -1) == s1.charAt(i-1) && interleaved[i - 1][0]){
                interleaved[i][0] = true;
            }
        }
        for(int j = 1; j <= len2; j++){
            if(s3.charAt(j - 1) == s2.charAt(j -1) && interleaved[0][j -1]){
                interleaved[0][j] = true;
            }
        }

        for(int i = 1; i <= len1; i++){
            for(int j = 1;j <= len2; j++){
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j]))
                        || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && interleaved[i][j - 1])){
                    interleaved[i][j] = true;
                }
            }
        }
        return interleaved[len1][len2];
    }

    public static void main(String[] args) {
//        boolean b = isInterleave("aabcc", "dbbca", "aadbbcbcac");
        boolean b = isInterleave("a", "", "a");
//        boolean b = isInterleave("abbcddef", "accbbbcd", "abbcddefaccbbbcd");
        System.out.println(b);
    }
}
