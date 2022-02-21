package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private SolutionA solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        solution = new SolutionA();
        assertSolution();
    }
    
    private void assertSolution()
    {
        ListNode a3 = new ListNode(3);
        ListNode a2 = new ListNode(2);
        ListNode a0 = new ListNode(0);
        ListNode a4 = new ListNode(4);
        
        a3.next = a2;
        a2.next = a0;
        a0.next = a4;
        a4.next = a2;
        
        assertEquals(a2, solution.detectCycle(a3));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
