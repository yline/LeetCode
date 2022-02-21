package com.test.base;

import com.test.SolutionA;
import com.test.SolutionB;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        solution = new SolutionA();
        testSolution();
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        testSolution();
    }
    
    private void testSolution()
    {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        
        node0.next = node1;
        node1.next = node2;
        
        assertEquals(false, solution.hasCycle(node0));
        
        node2.next = node0;
        assertEquals(true, solution.hasCycle(node0));
        
        node2.next = node1;
        assertEquals(true, solution.hasCycle(node0));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
