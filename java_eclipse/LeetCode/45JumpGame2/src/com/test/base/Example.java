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
        assertSolution();
    }
    
    private void assertSolution()
    {
        int[] numsA = {2, 3, 1, 1, 4};
        assertEquals(2, solution.jump(numsA));
        
        int[] numsB = {2, 1};
        assertEquals(1, solution.jump(numsB));
        
        int[] numsC = {2, 3, 1};
        assertEquals(1, solution.jump(numsC));
        
        int[] numsD = {1, 3, 2};
        assertEquals(2, solution.jump(numsD));
        
        int[] numsE = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        assertEquals(2, solution.jump(numsE));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
