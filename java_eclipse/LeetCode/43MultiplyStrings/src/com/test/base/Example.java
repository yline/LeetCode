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
        solution = new SolutionA();
    }
    
    public void testSolution()
    {
        assertEquals("6", solution.multiply("2", "3"));
        assertEquals("56088", solution.multiply("123", "456"));
        assertEquals("121", solution.multiply("11", "11"));
        assertEquals("625", solution.multiply("25", "25"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
