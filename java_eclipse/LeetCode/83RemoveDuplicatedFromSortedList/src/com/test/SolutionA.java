package com.test;

import com.test.base.ListNode;

/**
 * Given a sorted linked list,
 * delete all duplicates such that each element appear only once.
 * 给一个链表，删除所有重复的值
 * 
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 * 
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * 
 * @author YLine
 *
 * 2019年8月23日 上午9:16:21
 */
public class SolutionA
{
    public ListNode deleteDuplicates(ListNode head)
    {
        ListNode temp = head;
        while (null != temp && null != temp.next)
        {
            if (temp.val == temp.next.val)
            {
                temp.next = temp.next.next; // 删除重复的内容
            }
            else
            {
                temp = temp.next;
            }
        }
        return head;
    }
}
