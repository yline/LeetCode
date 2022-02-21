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
        solution = new SolutionA(new int[] {3,8,0,9,2,5});
        assertEquals(8, solution.next(2));
        assertEquals(8, solution.next(1));
        assertEquals(5, solution.next(1));
        assertEquals(-1, solution.next(2));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
