package com.test.base;

import com.test.SolutionA;
import com.test.SolutionB;

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
    
    private void assertSolution()
    {
        assertEquals(true, solution.canJump(new int[] {2, 3, 1, 1, 4}));
        assertEquals(false, solution.canJump(new int[] {3, 2, 1, 0, 4}));
        assertEquals(true, solution.canJump(new int[] {3, 2, 1, 0}));
        assertEquals(false, solution.canJump(new int[] {0, 1}));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
