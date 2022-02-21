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
        int[] citationsA = {0, 1, 3, 5, 6};
        assertEquals(3, solution.hIndex(citationsA));
        
        int[] citationsB = {};
        assertEquals(0, solution.hIndex(citationsB));
        
        int[] citationsC = {1, 1};
        assertEquals(1, solution.hIndex(citationsC));
        
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
