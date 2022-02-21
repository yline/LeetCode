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
        TreeNode rootA = new TreeNode(1);
        rootA.left = new TreeNode(2);
        rootA.right = new TreeNode(3);
        assertEquals(6, solution.maxPathSum(rootA));
        
        // B
        TreeNode rootB = new TreeNode(-10);
        
        TreeNode rootRightB = new TreeNode(20);
        rootB.left = new TreeNode(9);
        rootB.right = rootRightB;
        
        rootRightB.left = new TreeNode(15);
        rootRightB.right = new TreeNode(7);
        assertEquals(42, solution.maxPathSum(rootB));
        
        // C
        TreeNode rootC = new TreeNode(-10);
        
        TreeNode rootRightC = new TreeNode(-10);
        rootC.left = new TreeNode(9);
        rootC.right = rootRightC;
        
        TreeNode rootRightRightC = new TreeNode(1);
        rootRightC.right = rootRightRightC;
        
        rootRightRightC.left = new TreeNode(3);
        rootRightRightC.right = new TreeNode(4);
        assertEquals(9, solution.maxPathSum(rootC));
        
        // D
        TreeNode rootD = new TreeNode(2);
        rootD.left = new TreeNode(-1);
        rootD.left = new TreeNode(-2);
        
        // E
        TreeNode rootE = new TreeNode(2);
        
        TreeNode rootRightE = new TreeNode(-3);
        rootE.left = new TreeNode(9);
        rootE.right = rootRightE;
        
        TreeNode rootRightRightE = new TreeNode(1);
        rootRightE.right = rootRightRightE;
        
        rootRightRightE.left = new TreeNode(3);
        rootRightRightE.right = new TreeNode(4);
        assertEquals(13, solution.maxPathSum(rootE));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
