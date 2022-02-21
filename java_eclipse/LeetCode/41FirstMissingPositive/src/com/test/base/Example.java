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
    
    public void testSolutionA()
    {
        // A
        int[] candidatesA = {1, 2, 0};
        assertEquals(3, solution.firstMissingPositive(candidatesA));
        
        // B
        int[] candidatesB = {3, 4, -1, 1};
        assertEquals(2, solution.firstMissingPositive(candidatesB));
        
        // C
        int[] candidatesC = {7, 8, 9, 11, 12};
        assertEquals(1, solution.firstMissingPositive(candidatesC));
        
        // D
        int[] candidatesD = {1};
        assertEquals(2, solution.firstMissingPositive(candidatesD));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
