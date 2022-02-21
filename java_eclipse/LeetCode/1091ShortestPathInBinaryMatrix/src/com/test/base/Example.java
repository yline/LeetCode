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
        int resultA = solution.shortestPathBinaryMatrix(new int[][] {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}});
        System.out.println(resultA);
        int resultB = solution.shortestPathBinaryMatrix(new int[][] {{0, 1}, {1, 0}});
        System.out.println(resultB);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
