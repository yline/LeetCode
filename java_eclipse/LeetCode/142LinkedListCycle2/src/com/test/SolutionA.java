package com.test;

import java.util.HashSet;

import com.test.base.ListNode;

public class SolutionA
{
    public ListNode detectCycle(ListNode head)
    {
        ListNode node = head;
        HashSet<ListNode> visitedSet = new HashSet<>();
        
        while (null != node)
        {
            if (visitedSet.contains(node))
            {
                return node;
            }
            
            visitedSet.add(node);
            node = node.next;
        }
        
        return null;
    }
}
