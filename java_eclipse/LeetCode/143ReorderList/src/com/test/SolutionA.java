package com.test;

import com.test.base.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes,
 * only nodes itself may be changed.
 * 
 * @author YLine
 *
 * 2019年12月25日 上午11:12:46
 */
public class SolutionA
{
    public void reorderList(ListNode head)
    {
        // 不需要更改的情况
        if (null == head || null == head.next || null == head.next.next)
        {
            return;
        }
        
        // 计算，链表的长度
        int length = 0;
        ListNode temp = head;
        while (null != temp)
        {
            temp = temp.next;
            length++;
        }
        
        // 将链表切割成两个链表，前一个 和 后一个，后一个倒转
        int postSize = length / 2;
        int preSize = length - postSize;
        
        // 经历过当前遍历后，temp 是切割点
        temp = head;
        for (int i = 0; i < preSize - 1; i++)
        {
            temp = temp.next;
        }
        
        // 断开连接，并实现切割
        ListNode postTemp = temp.next;
        temp.next = null;
        
        ListNode preHead = head;
        ListNode postHead = reverse(postTemp);
        
        // 实现两个链表合并
        mergeList(preHead, postHead);
    }
    
    /**
     * 会破坏原有链表
     * @param head 原始链表
     * @return 反转后的内容
     */
    private static ListNode reverse(ListNode head)
    {
        if (null == head)
        {
            return null;
        }
        
        ListNode result = new ListNode(-1);
        result.next = head;
        
        // 开始反转
        ListNode right = head;
        while (null != right.next)
        {
            ListNode left = right.next;
            
            right.next = left.next; // 右侧倒数第二个，断开
            left.next = result.next; // 右侧倒数第一个，断开
            result.next = left; // 插入左侧第一个
        }
        
        return result.next;
    }
    
    private void mergeList(ListNode pre, ListNode post)
    {
        ListNode preTemp = pre;
        ListNode postTemp = post;
        
        while (null != postTemp && null != preTemp)
        {
            ListNode preNext = preTemp.next;
            ListNode postNext = postTemp.next;
            
            preTemp.next = postTemp;
            postTemp.next = preNext;
            
            preTemp = preNext;
            postTemp = postNext;
        }
    }
}
