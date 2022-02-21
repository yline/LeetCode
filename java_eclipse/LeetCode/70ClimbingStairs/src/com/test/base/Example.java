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
        assertEquals(1, solution.climbStairs(1));
        assertEquals(2, solution.climbStairs(2));
        assertEquals(3, solution.climbStairs(3));
        assertEquals(5, solution.climbStairs(4));
        assertEquals(8, solution.climbStairs(5));
        assertEquals(13, solution.climbStairs(6));
        assertEquals(21, solution.climbStairs(7));
        assertEquals(34, solution.climbStairs(8));
        assertEquals(55, solution.climbStairs(9));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
