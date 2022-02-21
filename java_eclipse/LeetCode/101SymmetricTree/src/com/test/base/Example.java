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
        solution = new SolutionA();
    }
    
    public void testSolution()
    {
        // A
        TreeNode rootA = new TreeNode(1);
        
        TreeNode aLeft = new TreeNode(2);
        aLeft.left = new TreeNode(3);
        aLeft.right = new TreeNode(4);
        
        TreeNode aRight = new TreeNode(2);
        aRight.left = new TreeNode(4);
        aRight.right = new TreeNode(3);
        
        rootA.left = aLeft;
        rootA.right = aRight;
        assertEquals(true, solution.isSymmetric(rootA));
        
        // B
        TreeNode rootB = new TreeNode(1);
        
        TreeNode bLeft = new TreeNode(2);
        bLeft.right = new TreeNode(3);
        
        TreeNode bRight = new TreeNode(2);
        bRight.right = new TreeNode(3);
        
        rootB.left = bLeft;
        rootB.right = bRight;
        assertEquals(false, solution.isSymmetric(rootB));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
