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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ch15 {

    /*
        题目:Write a method to replace all spaces in a string with ‘%20’
        将字符串中的所有的空白都通过%20来替换
     */

    public static String replaceBlank(String str) {
        if (str == null) {
            return null;
        }
        List<Character> characterList = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            if (character != ' ') {
                characterList.add(character);
            } else {
                characterList.addAll(Arrays.asList('%', '2', '0'));
            }
        }
        char[] newChars = new char[characterList.size()];
        for (int i = 0; i < characterList.size(); i++) {
            newChars[i] = characterList.get(i);
        }
        return new String(newChars);
    }

    public static String replaceBlankSimplified(String str) {
        if (str == null) {
            return null;
        }
    }

    public static void main(String[] args) {
        String test = "   ";
        System.out.println(replaceBlank(test));
    }

}
