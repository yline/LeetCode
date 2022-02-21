package com.test;

import com.test.base.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 给一个排序好的链表，删除所有重复的节点
 * 
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 * 
 * @author YLine
 *
 * 2019年8月20日 上午9:45:50
 */
public class SolutionA
{
    public ListNode deleteDuplicates(ListNode head)
    {
        ListNode result = new ListNode(-1);
        result.next = head;
        
        // 删除逻辑
        ListNode temp = result;
        boolean isDelete = false;
        while (null != temp && null != temp.next && null != temp.next.next)
        {
            if (temp.next.val == temp.next.next.val)
            {
                isDelete = true;
                
                temp.next = temp.next.next;
            }
            else
            {
                if (isDelete)
                {
                    isDelete = false;
                    
                    temp.next = temp.next.next;
                }
                else
                {
                    temp = temp.next;
                }
            }
        }
        
        if (isDelete)
        {
            isDelete = false;
            
            temp.next = temp.next.next;
        }
        
        return result.next;
    }
}
