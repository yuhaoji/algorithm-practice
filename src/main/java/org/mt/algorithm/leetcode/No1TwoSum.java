/* Project of UGC team

======================
Authors:haoji.yu

======================
Description:

======================
Major changs:

add by haoji.yu 2017/3/27

*/
package org.mt.algorithm.leetcode;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */


import java.util.HashMap;
import java.util.Map;

public class No1TwoSum {

    //O(n2)
    public static int[] method1(int[] input, int target) {
        int[] result = new int[2];
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] + input[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    //O(n)
    public static int[] method2(int[] input, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for (int index = 0; index < input.length; index++) {
            int diff = target - input[index];
            if (temp.containsKey(input[index])) {
                result[0] = temp.get(input[index]);
                result[1] = index;
                break;
            }
            temp.put(diff, index);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = method2(new int[]{3,2,4}, 6);
        for (int index : result) {
            System.out.print(index);
        }
    }

}
