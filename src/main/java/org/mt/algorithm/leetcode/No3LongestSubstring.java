/* Project of UGC team

======================
Authors:haoji.yu

======================
Description:

======================
Major changs:

add by haoji.yu 2017/3/30

*/
package org.mt.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No3LongestSubstring {


    /*
    Given a string, find the length of the longest substring without repeating characters.

    Examples:

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int length = s.toCharArray().length;
        for (int i = 0, j = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= j) {
                max = Math.max(max, i - j);
                j = map.get(ch) + 1;
            }
            map.put(ch, i);
            if (i == (length - 1)) {
                max = Math.max(max, i - j + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("bbbbb");
        System.out.println(length);
    }


}
