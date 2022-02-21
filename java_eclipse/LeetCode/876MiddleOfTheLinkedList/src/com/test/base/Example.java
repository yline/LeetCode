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
        
        ListNode resultA = solution.middleNode(node0);
        assertEquals(2, resultA.val);
        
        node4.next = new ListNode(5);
        ListNode resultB = solution.middleNode(node0);
        assertEquals(3, resultB.val);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
