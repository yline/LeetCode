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
        // B
        TreeNode rootB = new TreeNode(1);
        rootB.right = new TreeNode(2);
        
        TreeNode rootB1 = new TreeNode(2);
        rootB.left = rootB1;
        rootB1.right = new TreeNode(3);
        
        TreeNode rootB2 = new TreeNode(3);
        rootB1.left = rootB2;
        rootB2.left = new TreeNode(4);
        rootB2.right = new TreeNode(5);
        
        assertEquals(true, solution.hasPathSum(rootB, 3));
        assertEquals(true, solution.hasPathSum(rootB, 6));
        assertEquals(true, solution.hasPathSum(rootB, 10));
        assertEquals(true, solution.hasPathSum(rootB, 11));
        
        assertEquals(false, solution.hasPathSum(rootB, 12));
        assertEquals(false, solution.hasPathSum(rootB, 9));
        assertEquals(false, solution.hasPathSum(rootB, 8));
        assertEquals(false, solution.hasPathSum(rootB, 13));
        assertEquals(false, solution.hasPathSum(rootB, 14));
        assertEquals(false, solution.hasPathSum(rootB, 15));
        assertEquals(false, solution.hasPathSum(rootB, 16));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
