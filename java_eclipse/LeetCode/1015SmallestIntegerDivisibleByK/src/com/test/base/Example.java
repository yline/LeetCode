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
        assertEquals(1, solution.smallestRepunitDivByK(1));
        assertEquals(2, solution.smallestRepunitDivByK(11));
        assertEquals(3, solution.smallestRepunitDivByK(3));
        assertEquals(4, solution.smallestRepunitDivByK(101));
        assertEquals(5, solution.smallestRepunitDivByK(41));
        assertEquals(6, solution.smallestRepunitDivByK(8547));
        assertEquals(7, solution.smallestRepunitDivByK(239));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
