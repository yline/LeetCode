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
        int[] numA = {1, 2};
        int[] numB = {-2, -1};
        int[] numC = {-1, 2};
        int[] numD = {0, 2};
        assertEquals(2, solution.fourSumCount(numA, numB, numC, numD));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
