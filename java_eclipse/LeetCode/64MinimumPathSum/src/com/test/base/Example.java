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
        assertEquals(7, solution.minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        assertEquals(8, solution.minPathSum(new int[][] {{1, 2}, {5, 6}, {1, 1}}));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
