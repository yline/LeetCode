package com.test;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * 两个点
 * 
 * @author YLine
 *
 * 2018年10月23日 下午8:31:56
 */
public class SolutionA implements Solution
{
    @Override
    public ListNode middleNode(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        
        while (null != fast && null != fast.next)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
