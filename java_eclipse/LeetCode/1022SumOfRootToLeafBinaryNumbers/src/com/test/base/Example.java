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
    }
    
    public void testSolutionA()
    {
        solution = new SolutionA();
        assertSolution();
    }
    
    private void assertSolution()
    {
        TreeNode rootA = new TreeNode(1);
        
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(1);
        
        rootA.left = left;
        rootA.right = right;
        
        left.left = new TreeNode(0);
        left.right = new TreeNode(1);
        right.left = new TreeNode(0);
        right.right = new TreeNode(1);
        
        assertEquals(22, solution.sumRootToLeaf(rootA));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
