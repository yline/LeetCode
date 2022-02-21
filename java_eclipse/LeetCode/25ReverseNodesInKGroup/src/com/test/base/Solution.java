package com.test.base;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list
 * 
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 *
 * 给定一个链表，每间隔k个，颠倒一次
 * 当最后不满足k个，则按照他原来的数据
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 *  Only constant extra memory is allowed. // 不允许创建节点
 *  You may not alter the values in the list's nodes, only nodes itself may be changed. // 节点内容不能修改 
 * 
 * @author YLine
 *
 * 2018年8月29日 下午4:30:53
 */
public interface Solution
{
    /**
     * 原来是循环,获取
     * 
     */
    public ListNode reverseKGroup(ListNode head, int k);
}
