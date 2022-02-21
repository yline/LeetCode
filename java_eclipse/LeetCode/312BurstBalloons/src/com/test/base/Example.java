package com.test.base;


import com.test.SolutionA;
import com.test.SolutionB;

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
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertSolution();
    }
    
    private void assertSolution()
    {
        int[] numsA = {3, 1, 5, 8};
        assertEquals(167, solution.maxCoins(numsA));
        
        int[] numsB = {42, 23, 62, 2, 89, 97, 26, 82, 47, 23, 9, 2, 9, 11, 53, 49, 40, 3, 88, 76, 63, 11, 79, 37, 52,
            91, 5, 44, 71, 69, 20, 5, 74, 41, 70, 68, 26, 16, 62, 53, 47, 46, 26, 27, 99, 72, 4, 40, 77, 74, 89, 19, 26,
            7, 30, 79, 49, 75, 51, 28, 47, 26, 55, 81, 82, 15, 21, 89, 51, 10, 0, 50, 31, 32, 38, 7, 99, 13, 23, 98, 68,
            9, 54, 15, 34, 52, 58, 48, 66, 75, 6, 15, 91, 33, 15, 37, 25, 98, 98, 77, 60, 16, 82, 89, 48, 43, 1, 85, 39,
            99, 95, 86, 45, 90, 73, 45, 93, 99, 39, 57, 32, 47, 35, 79, 25, 54, 98, 34, 60, 90, 38, 40, 5, 5, 96, 21,
            18, 93, 69, 38, 85, 49, 15, 77, 84, 70, 52, 87, 73, 15, 65};
        assertEquals(53234968, solution.maxCoins(numsB));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
