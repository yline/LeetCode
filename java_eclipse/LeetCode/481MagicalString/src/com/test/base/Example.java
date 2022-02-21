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
    }
    
    public void testSolutionA()
    {
        solution = new SolutionA();
        for (int i = 1; i < 20; i++)
        {
            assertSolution(i);
        }
    }
    
    private void assertSolution(int n)
    {
        int length = solution.magicalString(n);
        System.out.println("n = " + n + ", m = " + length);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
