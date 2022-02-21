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
        int[][] matrixA = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        assertEquals(true, solution.searchMatrix(matrixA, 3));
        assertEquals(false, solution.searchMatrix(matrixA, 13));
        assertEquals(true, solution.searchMatrix(matrixA, 5));
        
        int[][] matrixB = {{1, 3}};
        assertEquals(false, solution.searchMatrix(matrixB, 2));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
