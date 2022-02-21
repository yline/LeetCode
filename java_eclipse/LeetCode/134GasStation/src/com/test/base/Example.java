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
        int[] gasA = {1, 2, 3, 4, 5};
        int[] costA = {3, 4, 5, 1, 2};
        assertEquals(3, solution.canCompleteCircuit(gasA, costA));
        
        int[] gasB = {2, 3, 4};
        int[] costB = {3, 4, 3};
        assertEquals(-1, solution.canCompleteCircuit(gasB, costB));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
