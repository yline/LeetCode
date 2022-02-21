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
        assertSolution();
    }
    
    private void assertSolution()
    {
        int[][] matrixA = new int[][] {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        solution = new SolutionA(matrixA);
        assertEquals(8, solution.sumRegion(2, 1, 4, 3));
        assertEquals(11, solution.sumRegion(1, 1, 2, 2));
        assertEquals(12, solution.sumRegion(1, 2, 2, 4));
        
        int[][] matrixB = new int[][] {{1}, {-7}};
        solution = new SolutionA(matrixB);
        System.out.println(solution.sumRegion(0, 0, 0, 0));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
