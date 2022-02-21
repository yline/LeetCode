package com.test;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * 画图决定
 * @author YLine
 *
 * 2018年10月23日 下午8:31:56
 */
public class SolutionA implements Solution
{
    @Override
    public ListNode reverseList(ListNode head)
    {
        if (null == head)
        {
            return head;
        }
        
        ListNode parent = new ListNode(0);
        
        parent.next = head;
        
        ListNode first = head;
        ListNode last = head.next;
        
        while (null != last)
        {
            // 交换
            first.next = last.next;
            last.next = parent.next;
            parent.next = last;
            
            // 复原
            last = first.next;
        }
        
        return parent.next;
    }
}
