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
        int[][] intervalsA = new int[][] {{2, 6}, {1, 3}, {8, 10}, {15, 18}};
        solution.merge(intervalsA);
        
        int[][] intervalsB = new int[][] {{1, 4}, {2, 3}};
        solution.merge(intervalsB);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
