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
        assertEquals("0.5", solution.fractionToDecimal(1, 2));
        assertEquals("2", solution.fractionToDecimal(2, 1));
        assertEquals("0.(6)", solution.fractionToDecimal(2, 3));
        assertEquals("0.(012)", solution.fractionToDecimal(4, 333));
        assertEquals("0.1(6)", solution.fractionToDecimal(1, 6));
        assertEquals("-6.25", solution.fractionToDecimal(-50, 8));
        assertEquals("-8.(3)", solution.fractionToDecimal(-50, 6));
        assertEquals("0.0000000004656612873077392578125", solution.fractionToDecimal(-1, -2147483648));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
