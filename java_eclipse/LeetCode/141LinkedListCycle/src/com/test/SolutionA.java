package com.test;

import java.util.HashSet;
import java.util.Set;

import com.test.base.ListNode;
import com.test.base.Solution;

/**
 * 链表由于是随机链接；
 * 
 * 因此：需要每个校验
 * 时间复杂度：n * log2(n)
 * 
 * 空间复杂度：新增了 n个内存
 * 
 * @author YLine
 *
 * 2018年10月23日 下午9:10:18
 */
public class SolutionA implements Solution
{
    @Override
    public boolean hasCycle(ListNode head)
    {
        Set<ListNode> nodeSet = new HashSet<>();
        
        ListNode temp = head;
        while (null != temp)
        {
            if (nodeSet.contains(temp))
            {
                return true;
            }
            else
            {
                nodeSet.add(temp);
            }
            temp = temp.next;
        }
        
        return false;
    }
}
