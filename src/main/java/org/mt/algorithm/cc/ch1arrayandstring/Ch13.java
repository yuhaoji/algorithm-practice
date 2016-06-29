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

    public static String removeDuplicateChar(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return "";
    }
}
