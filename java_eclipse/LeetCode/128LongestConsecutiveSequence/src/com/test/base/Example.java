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
        int[] numsA = {100, 4, 200, 1, 3, 2};
        assertEquals(4, solution.longestConsecutive(numsA));
        
        int[] numsB = {100, 4, 200, 1, 5, 2};
        assertEquals(2, solution.longestConsecutive(numsB));
        
        int[] numsC = {100, 4, 200, 1, 3, 3, 2};
        assertEquals(4, solution.longestConsecutive(numsC));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
