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
        TreeNode rootA = TreeNodeUtils.build(1, 2, 3, 4, 5);
        assertEquals(3, solution.diameterOfBinaryTree(rootA));
        
        TreeNode rootB = TreeNodeUtils.build(1, 2, null, 4, null, null, null, 8);
        assertEquals(3, solution.diameterOfBinaryTree(rootB));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
