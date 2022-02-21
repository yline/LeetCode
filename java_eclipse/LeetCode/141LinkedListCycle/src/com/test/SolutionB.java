package com.test;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * 原理：若有循环，则若快速执行能够等于慢速执行的，则可以断定链表为循环链表
 * 
 * 
 * 假设，从开始到循环节点长度为K，循环一次为(n-1)，则周期为n
 * 
 * 设执行次数为x，则慢的执行到:1*x，快的执行到:2*x
 * 
 * 若链表为循环，则必有 x - k = (2*x - k) % (n)
 * 
 * ==> x - k = (2*x - k) - j * (n) [j为某常数]
 * ==> x = j * n
 * 
 * 可以看到，当x = j*n时，若链表循环，则必定有相等的。
 * 
 * @author YLine
 *
 * 2018年10月24日 上午10:01:41
 */
public class SolutionB implements Solution
{
    
    @Override
    public boolean hasCycle(ListNode head)
    {
        if (null == head || null == head.next)
        {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast)
        {
            if (null == fast || null == fast.next)
            {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
