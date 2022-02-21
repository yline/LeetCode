package com.test;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * Two pass algorithm
 * 暴力破解：
 * 1，先计算链表长度
 * 2，再次遍历，然后将链表连接中断一次
 * 
 * 时间复杂度：2*n
 * 
 * @author YLine
 *
 * 2018年8月13日 下午6:05:21
 */
public class SolutionA implements Solution
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        // 定位到位置
        int length = 0;
        ListNode first = head;
        while (null != first)
        {
            first = first.next;
            length++;
        }
        
        // 得到拆分数据
        // 对 first重新 赋值
        first = head;
        
        ListNode parentResult = new ListNode(0);
        ListNode tempResult = parentResult;
        
        int position = length - n;
        
        for (int i = 0; i < position; i++)
        {
            tempResult.next = new ListNode(first.val);
            tempResult = tempResult.next;
            
            first = first.next;
        }
        
        // 拼接 数据
        tempResult.next = first.next;
        
        // logListNode(parentResult.next);
        
        return parentResult.next;
    }
}
