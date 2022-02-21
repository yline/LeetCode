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
        assertSolution();
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertSolution();
    }
    
    private void assertSolution()
    {
        Node nodeA1 = new Node();
        Node nodeA2 = new Node();
        
        nodeA1.val = 1;
        nodeA1.next = nodeA2;
        nodeA1.random = nodeA2;
        nodeA2.val = 2;
        nodeA2.next = null;
        nodeA2.random = nodeA2;
        solution.copyRandomList(nodeA1);
        
        Node nodeB1 = new Node();
        Node nodeB2 = new Node();
        
        nodeB1.val = 11;
        nodeB1.next = nodeB2;
        nodeB1.random = nodeB2;
        nodeB2.val = 22;
        nodeB2.next = null;
        nodeB2.random = nodeB1;
        solution.copyRandomList(nodeB1);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
