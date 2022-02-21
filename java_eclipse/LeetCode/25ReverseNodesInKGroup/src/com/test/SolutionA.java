package com.test;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * 
 * 方案：
 * 遍历k个节点，通过int[]记录下来，然后修改节点数值
 * PS:虽然不符合题意，但解决了问题
 * 
 * 时间复杂度：
 * n
 * @author YLine
 *
 * 2018年8月29日 下午5:03:16
 */
public class SolutionA implements Solution
{
    @Override
    public ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode node = head;
        while (null != node)
        {
            node = reverseGroup(node, k);
        }
        return head;
    }
    
    /**
     * 反转一次
     * @param node  当前的游标剩下的 链表
     * @param k 反转周期
     * @return
     */
    public ListNode reverseGroup(ListNode node, int k)
    {
        ListNode cursor = node;
        int[] cacheNumber = new int[k];
        int i = 0;
        
        // 统计node的个数
        while (null != cursor && i < k)
        {
            cacheNumber[i] = cursor.val;
            
            cursor = cursor.next;
            i++;
        }
        
        // k的值 大于节点数,不需要改变
        if (k > i)
        {
            return null;
        }
        
        cursor = node;
        for (int j = i - 1; j >= 0; j--)
        {
            cursor.val = cacheNumber[j];
            cursor = cursor.next;
        }
        
        return cursor;
    }
}
