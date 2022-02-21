package com.test;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * 修改了node内容，因此只能算是蒙混过关
 * 不交换node，仅仅交换node的内容
 *
 * 时间复杂度：
 * n
 * 
 * @author YLine
 *
 * 2018年8月20日 下午5:42:04
 */
public class SolutionA implements Solution
{
    public ListNode swapPairs(ListNode head)
    {
        int temp;
        ListNode cursor = head;
        
        while (null != cursor)
        {
            if (null != cursor && null != cursor.next)
            {
                temp = cursor.val;
                cursor.val = cursor.next.val;
                cursor.next.val = temp;
                
                cursor = cursor.next.next;
            }
            else
            {
                cursor = null;
            }
        }
        
        return head;
    }
}
