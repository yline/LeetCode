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
        assertEquals(185, solution.divide(555, 3));
        assertEquals(185, solution.divide(556, 3));
        assertEquals(184, solution.divide(554, 3));
        
        assertEquals(0, solution.divide(1, 3));
        assertEquals(1, solution.divide(4, 3));
        
        assertEquals(-2147483648 / -2147483648, solution.divide(-2147483648, -2147483648));
        assertEquals(-1010369383 / -2147483648, solution.divide(-1010369383, -2147483648));
        
        assertEquals(4 / 1, solution.divide(4, 1));
        assertEquals(-2147483648 / 1, solution.divide(-2147483648, 1));
        
        assertEquals(2147483647, solution.divide(-2147483648, -1));
        
        assertEquals(Integer.MAX_VALUE / 16, solution.divide(Integer.MAX_VALUE, 16));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
