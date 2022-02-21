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
    
    public void testSolution()
    {
        int number = solution.longestValidParentheses("(");
        assertEquals(number, 0);
        
        number = solution.longestValidParentheses("(()");
        assertEquals(number, 2);
        
        number = solution.longestValidParentheses(")()())");
        assertEquals(number, 4);
        
        number = solution.longestValidParentheses("()(()");
        assertEquals(number, 2);
        
        number = solution.longestValidParentheses("()(())");
        assertEquals(number, 6);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
