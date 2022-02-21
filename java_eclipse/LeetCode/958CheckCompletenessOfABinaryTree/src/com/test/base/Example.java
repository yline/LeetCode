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
        TreeNode rootA = new TreeNode(1);
        
        TreeNode rootALeft = new TreeNode(2);
        TreeNode rootARight = new TreeNode(3);
        rootA.left = rootALeft;
        rootA.right = rootARight;
        
        rootALeft.left = new TreeNode(4);
        rootALeft.right = new TreeNode(5);
        
        rootARight.left = new TreeNode(6);
        
        assertEquals(true, solution.isCompleteTree(rootA));
        
        TreeNode rootB = new TreeNode(1);
        
        TreeNode rootBLeft = new TreeNode(2);
        TreeNode rootBRight = new TreeNode(3);
        rootB.left = rootBLeft;
        rootB.right = rootBRight;
        
        rootBLeft.left = new TreeNode(4);
        rootBLeft.right = new TreeNode(5);
        
        rootBRight.right = new TreeNode(7);
        
        assertEquals(false, solution.isCompleteTree(rootB));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
