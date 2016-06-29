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

public class Ch12 {

    /*
        题目:Write code to reverse a C-Style String. (C-String means that “abcd” is represented as
        five characters, including the null character.)
        反转一个字符串
     */

    public static void main(String[] args) {
        String test = "12345";
        String newTest = reverse2(test);
        System.out.println(newTest);
    }


    public static String reverse(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        int length = str.length();
        char[] reverseChar = new char[length];
        for (int i = 0;i< length;i++) {
            reverseChar[length - 1 - i] = str.charAt(i);
        }
        return String.valueOf(reverseChar);
    }

    //另一种方式,其实使用的空间也是一样的,因为str.toCharArray()其实也是建了一个char的数组
    public static String reverse2(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        char[] strChar = str.toCharArray();
        int endIndex = str.length() - 1;
        int starIndex = 0;
        while (starIndex < endIndex) {
            char temp = strChar[starIndex];
            strChar[starIndex] = strChar[endIndex];
            strChar[endIndex] = temp;
            starIndex++;
            endIndex--;
        }
        return String.valueOf(strChar);
    }
}
