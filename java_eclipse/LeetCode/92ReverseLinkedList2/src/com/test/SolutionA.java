package com.test;

import com.test.base.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * @author YLine
 *
 * 2019年9月12日 下午6:05:19
 */
public class SolutionA
{
    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if (m == n)
        {
            return head;
        }
        
        // 构建一个结果
        ListNode result = new ListNode(-1);
        result.next = head;
        
        // 遍历到 m 的前一个
        ListNode top = result;
        for (int i = 1; i < m; i++)
        {
            top = top.next;
        }
        
        System.out.println("m top = " + top.val);

        ListNode left = top.next;
        ListNode right = left;
        for (int i = m; i < n; i++)
        {
            top.next = right.next;
            
            right.next = right.next.next;
            
            top.next.next = left;
            left = top.next;
        }

        return result.next;
    }
}
