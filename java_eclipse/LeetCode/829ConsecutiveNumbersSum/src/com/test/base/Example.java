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
        assertEquals(2, solution.consecutiveNumbersSum(5));
        assertEquals(2, solution.consecutiveNumbersSum(6));
        assertEquals(3, solution.consecutiveNumbersSum(9));
        assertEquals(4, solution.consecutiveNumbersSum(15));
        assertEquals(4, solution.consecutiveNumbersSum(85));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
