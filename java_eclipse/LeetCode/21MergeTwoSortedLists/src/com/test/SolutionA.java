package com.test;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * 遍历比较两个链表
 * 
 * 时间复杂度：n+m
 * @author YLine
 *
 * 2018年8月15日 下午4:02:53
 */
public class SolutionA implements Solution
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (null == l1)
        {
            return l2;
        }
        
        if (null == l2)
        {
            return l1;
        }
        
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (null != l1 && null != l2)
        {
            if (l1.val < l2.val)
            {
                temp.next = new ListNode(l1.val);
                temp = temp.next;
                
                l1 = l1.next;
            }
            else
            {
                temp.next = new ListNode(l2.val);
                temp = temp.next;
                
                l2 = l2.next;
            }
        }
        
        // 结束时,对空进行判断
        if (null != l1)
        {
            temp.next = l1;
        }
        
        if (null != l2)
        {
            temp.next = l2;
        }
        
        return result.next;
    }
    
}
