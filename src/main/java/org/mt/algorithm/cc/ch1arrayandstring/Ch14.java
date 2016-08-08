/* Project of UGC team

======================
Authors:haoji.yu

======================
Description:

======================
Major changs:

add by haoji.yu 16/8/8

*/
package org.mt.algorithm.cc.ch1arrayandstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ch14 {

    /*
        Write a method to decide if two strings are anagrams or not
        完成一个方法判断两个字符串是否是一个字谜
     */

    //方法一: 计算每个字符的数量是否相同
    public static boolean isAnagramsWithMap(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        if (first.equals(second)) {
            return false;
        }
        Map<Character, Integer> firstCharMap = getCharMap(first);
        Map<Character, Integer> secondCharMap = getCharMap(second);
        if (firstCharMap.size() != secondCharMap.size()) {
            return false;
        }
        for (Character character : firstCharMap.keySet()) {
            if (!firstCharMap.get(character).equals(secondCharMap.get(character))) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> getCharMap(String string) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (char ch : string.toCharArray()) {
            int count = charMap.get(ch) == null ? 1 : charMap.get(ch) + 1;
            charMap.put(ch, count);
        }
        return charMap;
    }

    //方法二: 排序后比较
    public static boolean isAnagramsWithSort(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        if (first.equals(second)) {
            return false;
        }
        return sort(first).equals(sort(second));
    }

    private static String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String first = "loops";
        String second = "pools";
        System.out.println(isAnagramsWithMap(first, second));
    }

}
