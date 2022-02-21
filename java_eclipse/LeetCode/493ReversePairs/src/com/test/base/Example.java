package com.test.base;

import com.test.SolutionA;
import com.test.SolutionB;
import com.test.SolutionC;

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
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertSolution();
    }
    
    public void testSolutionC()
    {
        solution = new SolutionC();
        assertSolution();
    }
    
    private void assertSolution()
    {
        assertEquals(2, solution.reversePairs(new int[] {1, 3, 2, 3, 1}));
        assertEquals(3, solution.reversePairs(new int[] {2, 4, 3, 5, 1}));
        assertEquals(9,
            solution.reversePairs(new int[] {2147483647, 2147483647, -2147483647, -2147483647, -2147483647,
                2147483647}));
        assertEquals(0,
            solution.reversePairs(new int[] {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
