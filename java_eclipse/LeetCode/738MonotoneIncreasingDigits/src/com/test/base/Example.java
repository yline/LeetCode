package com.test.base;

import com.test.SolutionA;

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
    
    private void assertSolution()
    {
        assertEquals(9, solution.monotoneIncreasingDigits(10));
        assertEquals(1234, solution.monotoneIncreasingDigits(1234));
        assertEquals(299, solution.monotoneIncreasingDigits(332));
        assertEquals(899999, solution.monotoneIncreasingDigits(999998));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
