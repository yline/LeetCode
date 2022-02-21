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
        rootA.left = new TreeNode(9);
        
        TreeNode rightA1 = new TreeNode(20);
        rightA1.left = new TreeNode(15);
        rightA1.right = new TreeNode(7);
        rootA.right = rightA1;
        
        assertEquals(2, solution.minDepth(rootA));
        
        // B
        TreeNode rootB = new TreeNode(1);
        rootB.right = new TreeNode(2);
        
        TreeNode rootB1 = new TreeNode(2);
        rootB.left = rootB1;
        rootB1.right = new TreeNode(3);
        
        TreeNode rootB2 = new TreeNode(3);
        rootB1.left = rootB2;
        rootB2.left = new TreeNode(4);
        rootB2.right = new TreeNode(4);
        
        assertEquals(2, solution.minDepth(rootB));
        
        // C
        TreeNode rootC = new TreeNode(1);
        rootC.left = new TreeNode(2);
        assertEquals(2, solution.minDepth(rootC));
        
        // D
        TreeNode rootD = new TreeNode(1);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
