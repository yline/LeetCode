package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        assertSolution();
    }
    
    private void assertSolution()
    {
        SolutionA solution = new SolutionA();
        for (int i = 1; i <= 15; i++)
        {
            solution.countArrangement(i);
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
