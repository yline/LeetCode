package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
        solution = new SolutionA();
    }
    
    public void testSolutionA()
    {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        
        assertEqual(1234, node0);
        
        ListNode result = solution.reverseList(node0);
        assertEqual(43210, result);
    }
    
    private void assertEqual(int expect, ListNode result)
    {
        int total = 0;
        
        ListNode temp = result;
        while (null != temp)
        {
            total *= 10;
            total += temp.val;
            
            temp = temp.next;
        }
        
        assertEquals(expect, total);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
