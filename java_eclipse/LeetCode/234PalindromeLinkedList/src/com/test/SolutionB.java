package com.test;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * 空间复杂度为1
 * 
 * 思路就是，反转链条；但要求不破坏链条；
 * 
 * @author YLine
 *
 * 2018年7月24日 下午4:33:17
 */
public class SolutionB implements Solution
{
    
    @Override
    public boolean isPalindrome(ListNode head)
    {
        ListNode source = head; // 原始链表
        
        // 造一个，反转链表
        ListNode reverseSource = reverseList(source);
        
        return true;
    }
    
    /**
     * 反转成功了，可是原始链条也被破坏了
     */
    private ListNode reverseList(ListNode head)
    {
        ListNode result = new ListNode(-1);
        result.next = head;
        
        ListNode tempLeft = head;
        ListNode tempRight = head;
        while (null != tempRight.next)
        {
            result.next = tempRight.next;
            tempRight.next = tempRight.next.next;
            
            result.next.next = tempLeft;
            tempLeft = result.next;
        }
        
        return result.next;
    }
}
