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
        // A
        TreeNode rootA = new TreeNode(3);
        
        TreeNode aRight = new TreeNode(20);
        aRight.left = new TreeNode(15);
        aRight.right = new TreeNode(7);
        
        rootA.left = new TreeNode(9);
        rootA.right = aRight;
        
        assertEquals(3, solution.maxDepth(rootA));
        
        // B
        TreeNode rootB = new TreeNode(1);
        
        TreeNode bLeft = new TreeNode(2);
        bLeft.left = new TreeNode(4);
        
        TreeNode bRight = new TreeNode(3);
        bRight.right = new TreeNode(5);
        
        rootB.left = bLeft;
        rootB.right = bRight;
        
        assertEquals(3, solution.maxDepth(rootB));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
