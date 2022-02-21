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
        assertEquals(1, solution.scoreOfParentheses("()"));
        assertEquals(2, solution.scoreOfParentheses("()()"));
        assertEquals(2, solution.scoreOfParentheses("(())"));
        assertEquals(6, solution.scoreOfParentheses("(()(()))"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
