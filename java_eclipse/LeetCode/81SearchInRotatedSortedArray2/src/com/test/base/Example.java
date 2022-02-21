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
        int[] numA = new int[]{2,5,6,0,0,1,2};
        assertEquals(true, solution.search(numA, 0));
        assertEquals(false, solution.search(numA, 3));
        
        assertEquals(false, solution.search(new int[] {}, 5));
        assertEquals(true, solution.search(new int[] {2, 2, 2, 2, 2, 2, 2}, 2));
        assertEquals(true, solution.search(new int[] {1, 3, 1, 1}, 3));
        assertEquals(true, solution.search(new int[] {1, 3, 1, 1, 1}, 3));
        assertEquals(true, solution.search(new int[] {1, 2, 0, 1, 1, 1}, 0));
        
        assertEquals(false, solution.search(new int[] {1, 3}, 0));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
