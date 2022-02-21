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
        int[] customersA = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpyA = {0, 1, 0, 1, 0, 1, 0, 1};
        assertEquals(16, solution.maxSatisfied(customersA, grumpyA, 3));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
