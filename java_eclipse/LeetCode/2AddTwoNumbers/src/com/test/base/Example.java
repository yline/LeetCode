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
    
    public void testSolution()
    {
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(3);
        node12.next = node13;
        node11.next = node12;
        
        ListNode node21 = new ListNode(5);
        ListNode node22 = new ListNode(5);
        ListNode node23 = new ListNode(7);
        ListNode node24 = new ListNode(3);
        ListNode node25 = new ListNode(2);
        node24.next = node25;
        node23.next = node24;
        node22.next = node23;
        node21.next = node22;
        
        ListNode result = solution.addTwoNumbers(node11, node21);
        
        assertEquals(7, result.val);
        assertEquals(9, result.next.val);
        assertEquals(0, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(2, result.next.next.next.next.val);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
