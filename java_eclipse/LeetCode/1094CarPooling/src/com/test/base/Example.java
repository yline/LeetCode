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
        int[][] tripsA = {{2, 1, 5}, {3, 3, 7}};
        assertEquals(false, solution.carPooling(tripsA, 4));
        
        int[][] tripsB = {{2, 1, 5}, {3, 3, 7}};
        assertEquals(true, solution.carPooling(tripsB, 5));
        
        int[][] tripsC = {{2, 1, 5}, {3, 5, 7}};
        assertEquals(true, solution.carPooling(tripsC, 3));
        
        int[][] tripsD = {{3, 2, 7}, {3, 7, 9}, {8, 3, 9}};
        assertEquals(true, solution.carPooling(tripsD, 11));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
