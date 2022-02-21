package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

/**
 * 严重怀疑正确answer
 */
public class Example extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
        solution = new SolutionA();
    }
    
    public void testSolution()
    {
        assertEquals(0, solution.reverse(0));
        assertEquals(321, solution.reverse(123));
        assertEquals(-321, solution.reverse(-123));
        assertEquals(0, solution.reverse(1534236469));
        assertEquals(0, solution.reverse(-2147483648));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
