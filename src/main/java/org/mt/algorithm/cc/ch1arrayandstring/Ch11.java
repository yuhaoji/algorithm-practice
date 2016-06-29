/* Project of UGC team

======================
Authors:haoji.yu

======================
Description:

======================
Major changs:

add by haoji.yu 16/6/27

*/
package org.mt.algorithm.cc.ch1arrayandstring;

import java.util.Arrays;

public class Ch11 {

    /*
        题目:
        Implement an algorithm to determine if a string has all unique characters. What if you
        can not use additional data structures?
        判断一个字符串中的所有字符是否都是不重复的
     */

    public static void main(String[] args) {
        String test = "abcdcdddee";
        System.out.println(isAllUniqueWithSort(test));
        System.out.println(test);
    }

    //O(n^2), 不使用额外的存储空间
    public static boolean isAllUnique(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    return false;
                }
            }
        }
        return true;
    }

    //O(n), 假设为asc字符, 需要额外的标注是否存在的存储空间
    public static boolean isAllUnique1(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        boolean[] haveChar = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            if (haveChar[str.charAt(i)]) {
                return false;
            }
            haveChar[str.charAt(i)] = true;
        }
        return true;
    }

    //O(nlogn), 先通过O(nlogn)的排序来对str中的char进行排序, 再两两比较获取是否重复
    public static boolean isAllUniqueWithSort(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }
        return true;
    }


}
