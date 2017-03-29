/* Project of UGC team

======================
Authors:haoji.yu

======================
Description:

======================
Major changs:

add by haoji.yu 2017/3/29

*/
package org.mt.algorithm.leetcode;

import java.util.*;

public class No2AddTwoNumbers {

    /*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
     */

    private static class ListNode {
        int val;

        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode method2(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode first = new ListNode(0);
        ListNode before = first;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(sum % 10);
            before.next = newNode;
            before = newNode;
            sum /= 10;
        }
        if (sum > 0) {
            before.next = new ListNode(sum);
        }
        return first.next;
    }

    //最普通的方式
    public static ListNode method1(ListNode l1, ListNode l2) {
        int size1 = getSize(l1);
        int size2 = getSize(l2);
        int max = size1 > size2 ? size1 : size2;
        Map<Integer, Integer> map1 = buildMap(l1);
        Map<Integer, Integer> map2 = buildMap(l2);
        int more = 0;
        ListNode prefix = null;
        ListNode resultNode = null;
        for (int i=1;i<=max ;i++) {
            Integer value1 = map1.get(i) == null ? 0 : map1.get(i);
            Integer value2 = map2.get(i) == null ? 0 : map2.get(i);
            int result = value1 + value2 + more;
            if (result >= 10) {
                more = result / 10;
                result = result % 10;
            }else{
                more = 0;
            }
            ListNode newNode = new ListNode(result);
            if (prefix != null) {
                prefix.next = newNode;
            }else{
                resultNode = newNode;
            }
            prefix = newNode;
        }
        if (more > 0) {
            prefix.next = new ListNode(more);
        }
        return resultNode;
    }

    private static Map<Integer, Integer> buildMap(ListNode listNode) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        int index = 1;
        while (listNode != null) {
            result.put(index, listNode.val);
            listNode = listNode.next;
            index++;
        }
        return result;
    }

    private static int getSize(ListNode listNode) {
        int result = 1;
        while (listNode.next != null) {
            listNode = listNode.next;
            result++;
        }
        return result;
    }

    private static ListNode buildListNode(List<Integer> input) {
        ListNode after = null;
        ListIterator<Integer> listIterator = input.listIterator(input.size());
        while (listIterator.hasPrevious()) {
            ListNode listNode = new ListNode(listIterator.previous());
            listNode.next = after;
            after = listNode;
        }
        return after;
    }

    public static void main(String[] args) {
        ListNode l1 = buildListNode(Arrays.asList(2,4,3));
        ListNode l2 = buildListNode(Arrays.asList(5,6,4));
        ListNode l3 = method2(l1, l2);
        printListNode(l3);
    }

    private static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }

}
