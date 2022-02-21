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
        TreeNode root = new TreeNode(5);
        
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(6);
        root.left = left;
        root.right = right;
        
        left.left = new TreeNode(2);
        left.right = new TreeNode(4);
        
        right.right = new TreeNode(7);
        
        assertEquals(true, solution.findTarget(root, 9));
        assertEquals(false, solution.findTarget(root, 28));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
