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
        assertEquals(1, solution.lastRemaining(1));
        assertEquals(2, solution.lastRemaining(2));
        assertEquals(2, solution.lastRemaining(3));
        assertEquals(2, solution.lastRemaining(4));
        assertEquals(2, solution.lastRemaining(5));
        assertEquals(4, solution.lastRemaining(6));
        assertEquals(4, solution.lastRemaining(7));
        assertEquals(6, solution.lastRemaining(8));
        assertEquals(6, solution.lastRemaining(9));
        assertEquals(8, solution.lastRemaining(10));
        assertEquals(8, solution.lastRemaining(11));
        assertEquals(6, solution.lastRemaining(12));
        assertEquals(6, solution.lastRemaining(13));
        assertEquals(8, solution.lastRemaining(14));
        assertEquals(8, solution.lastRemaining(15));
        assertEquals(6, solution.lastRemaining(16));
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertEquals(1, solution.lastRemaining(1));
        assertEquals(2, solution.lastRemaining(2));
        assertEquals(2, solution.lastRemaining(3));
        assertEquals(2, solution.lastRemaining(4));
        assertEquals(2, solution.lastRemaining(5));
        assertEquals(4, solution.lastRemaining(6));
        assertEquals(4, solution.lastRemaining(7));
        assertEquals(6, solution.lastRemaining(8));
        assertEquals(6, solution.lastRemaining(9));
        assertEquals(8, solution.lastRemaining(10));
        assertEquals(8, solution.lastRemaining(11));
        assertEquals(6, solution.lastRemaining(12));
        assertEquals(6, solution.lastRemaining(13));
        assertEquals(8, solution.lastRemaining(14));
        assertEquals(8, solution.lastRemaining(15));
        assertEquals(6, solution.lastRemaining(16));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
