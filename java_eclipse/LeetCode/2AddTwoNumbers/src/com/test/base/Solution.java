package com.test.base;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself
 * 
 * 给定两个 非负数的 链表
 * 每个链表中的节点，储存一个反顺序写成的数字，将两个链表求和
 * 可以假设两个链表中，没有包含0
 * 
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * @author YLine
 *
 * 2016年12月22日 下午1:21:36
 */
public interface Solution
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2);
}
