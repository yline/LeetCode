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
        ListNode headA = ListNodeUtils.buildListNode(1, 2, 3, 4);
        solution.reorderList(headA);
        ListNodeUtils.print(headA);
        
        ListNode headB = ListNodeUtils.buildListNode(1, 2, 3, 4, 5);
        solution.reorderList(headB);
        ListNodeUtils.print(headB);
        
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
