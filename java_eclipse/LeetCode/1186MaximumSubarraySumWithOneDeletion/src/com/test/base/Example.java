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
        assertEquals(4, solution.maximumSum(new int[] {1, -2, 0, 3}));
        assertEquals(4, solution.maximumSum(new int[] {1, -2, -2, 1, 3}));
        
        int[] array3 = {11, -10, -11, 8, 7, -6, 9, 4, 11, 6, 5, 0};
        assertEquals(50, solution.maximumSum(array3));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
