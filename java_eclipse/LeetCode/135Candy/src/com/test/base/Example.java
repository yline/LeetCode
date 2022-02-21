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
        assertEquals(5, solution.candy(new int[] {1, 0, 2}));
        assertEquals(4, solution.candy(new int[] {1, 2, 2}));
        assertEquals(13, solution.candy(new int[] {1, 2, 3, 3, 3, 2, 1}));
        assertEquals(7, solution.candy(new int[] {1, 3, 2, 2, 1}));
        assertEquals(12, solution.candy(new int[] {29, 51, 87, 87, 72, 12}));
        assertEquals(11, solution.candy(new int[] {1, 3, 4, 5, 2}));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
