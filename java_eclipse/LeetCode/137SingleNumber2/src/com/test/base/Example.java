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
        assertEquals(3, solution.singleNumber(new int[] {2, 2, 3, 2}));
        assertEquals(99, solution.singleNumber(new int[] {0, 1, 0, 1, 0, 1, 99}));
        assertEquals(4, solution.singleNumber(new int[] {-2, -2, 1, 1, -3, 1, -3, -3, 4, -2}));
        assertEquals(-4, solution.singleNumber(new int[] {-2, -2, 1, 1, -3, 1, -3, -3, -4, -2}));
        assertEquals(1, solution.singleNumber(new int[] {-2147483648, -2147483648, -2147483648, 1}));
        assertEquals(2147483647,
            solution.singleNumber(new int[] {43, 16, 45, 89, 45, -2147483648, 45, 2147483646, -2147483647, -2147483648,
                43, 2147483647, -2147483646, -2147483648, 89, -2147483646, 89, -2147483646, -2147483647, 2147483646,
                -2147483647, 16, 16, 2147483646, 43}));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
