package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        assertSolution();
    }
    
    private void assertSolution()
    {
        SolutionA solution = new SolutionA();
        int[] preA = {1, 2, 4, 5, 3, 6, 7};
        int[] postA = {4, 5, 2, 6, 7, 3, 1};
        TreeNode rootA = solution.constructFromPrePost(preA, postA);
        System.out.println(rootA);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
