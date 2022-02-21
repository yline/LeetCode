package com.test.base;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * 将两个已排序的链表，组合成一个新的有序链表
 * 
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 * @author YLine
 *
 * 2018年8月15日 下午3:57:23
 */
public interface Solution
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2);
}
