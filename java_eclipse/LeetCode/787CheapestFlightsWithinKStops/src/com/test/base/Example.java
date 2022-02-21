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
        int[][] flightsA = new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        assertEquals(500, solution.findCheapestPrice(3, flightsA, 0, 2, 0));
        assertEquals(200, solution.findCheapestPrice(3, flightsA, 0, 2, 1));
        
        int[][] flightsB = new int[][] {{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}};
        assertEquals(-1, solution.findCheapestPrice(5, flightsB, 2, 1, 1));
        
        int[][] flightsC = new int[][] {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        assertEquals(7, solution.findCheapestPrice(5, flightsC, 0, 2, 2));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
