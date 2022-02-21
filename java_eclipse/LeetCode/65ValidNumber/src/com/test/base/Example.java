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
        assertEquals(true, solution.isNumber("0"));
        assertEquals(true, solution.isNumber(" 0.1 "));
        assertEquals(false, solution.isNumber("abc"));
        assertEquals(false, solution.isNumber("1 a"));
        
        assertEquals(true, solution.isNumber("2e10"));
        assertEquals(true, solution.isNumber(" -90e3   "));
        assertEquals(false, solution.isNumber(" 1e"));
        assertEquals(false, solution.isNumber("e3"));
        
        assertEquals(true, solution.isNumber(" 6e-1"));
        assertEquals(false, solution.isNumber(" 99e2.5 "));
        assertEquals(true, solution.isNumber("53.5e93"));
        assertEquals(false, solution.isNumber(" --6 "));
        
        assertEquals(false, solution.isNumber("-+3"));
        assertEquals(false, solution.isNumber("95a54e53"));
        
        assertEquals(true, solution.isNumber(".1"));
        assertEquals(false, solution.isNumber(".-4"));
        assertEquals(false, solution.isNumber("."));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
