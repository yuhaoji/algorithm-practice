/* Project of UGC team

======================
Authors:haoji.yu

======================
Description:

======================
Major changs:

add by haoji.yu 16/6/29

*/
package org.mt.algorithm.cc.ch1arrayandstring;

public class Ch13 {

    /*
        题目:
        Design an algorithm and write code to remove the duplicate characters in a string
        without using any additional buffer. NOTE: One or two additional variables are fine.
        An extra copy of the array is not.
        消除字符中重复的字符,不能使用额外的空间
     */

    //O(n2)
    public static String removeDuplicateChar(String str) {
        int length = str.length();
        if (length <= 1) {
            return str;
        }
        char[] result = new char[str.length()];
        int index = 0;
        for (int i = 0; i < length; i++) {
            int j = i - 1;
            for (; j >= 0; j--) {
                if (str.charAt(i) == str.charAt(j)) {
                    break;
                }
            }
            if (j < 0) {
                result[index] = str.charAt(i);
                index++;
            }
        }
        return new String(result).trim();
    }

    public static void main(String[] args) {
        String test = "aabacb";
        String result = removeDuplicateChar(test);
        System.out.println(result);
    }

}
