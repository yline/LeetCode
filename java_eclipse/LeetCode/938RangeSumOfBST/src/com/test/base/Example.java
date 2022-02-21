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
        TreeNode nodeA = TreeNodeUtils.build(10, 5, 15, 3, 7, null, 18);
        assertEquals(32, solution.rangeSumBST(nodeA, 7, 15));
        
        TreeNode nodeB = TreeNodeUtils.build(10, 5, 15, 3, 7, 13, 18, 1, null, 6);
        assertEquals(23, solution.rangeSumBST(nodeB, 6, 10));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
