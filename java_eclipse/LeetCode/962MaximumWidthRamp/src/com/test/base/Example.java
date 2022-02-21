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
        assertEquals(2, solution.maxWidthRamp(new int[] {2, 1, 3}));
        assertEquals(4, solution.maxWidthRamp(new int[] {6, 0, 8, 2, 1, 5}));
        assertEquals(7, solution.maxWidthRamp(new int[] {9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
