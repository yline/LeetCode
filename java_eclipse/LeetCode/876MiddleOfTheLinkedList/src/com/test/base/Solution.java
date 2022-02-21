package com.test.base;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * 一个单向的非空的链表，返回链表的中间值
 * 
 * If there are two middle nodes, return the second middle node.
 * 如果，中间有两个值，则返回第二个值
 * 
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * 
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * 
 * @author YLine
 *
 * 2018年10月24日 上午11:04:36
 */
public interface Solution
{
    ListNode middleNode(ListNode head);
}
