package com.test.base;

import java.util.ArrayList;

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
        Node nodeA1 = new Node(1, new ArrayList<Node>());
        Node nodeA2 = new Node(2, new ArrayList<Node>());
        Node nodeA3 = new Node(3, new ArrayList<Node>());
        Node nodeA4 = new Node(4, new ArrayList<Node>());
        
        nodeA1.neighbors.add(nodeA2);
        nodeA1.neighbors.add(nodeA4);
        
        nodeA2.neighbors.add(nodeA1);
        nodeA2.neighbors.add(nodeA3);
        
        nodeA3.neighbors.add(nodeA2);
        nodeA3.neighbors.add(nodeA4);
        
        nodeA4.neighbors.add(nodeA1);
        nodeA4.neighbors.add(nodeA3);
        
        NodeUtil.print(nodeA1);
        Node resultA = solution.cloneGraph(nodeA1);
        NodeUtil.print(resultA);
        
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
