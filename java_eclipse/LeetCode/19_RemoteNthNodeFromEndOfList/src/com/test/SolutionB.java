package com.test;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * One pass algorithm 
 * 假设 链表长度L，倒数第n个，表示正数第(L-n)
 * 因此，第一条链表遍历到n，接下来再次遍历就是(L-n)次
 * 
 * @author YLine
 *
 * 2018年8月14日 上午9:59:42
 */
public class SolutionB implements Solution
{
    
    @Override
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++)
        {
            first = first.next;
        }
        
        // Move first to the end, maintaining the gap
        while (first != null)
        {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        return dummy.next;
    }
}
