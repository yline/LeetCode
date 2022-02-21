package com.test.base;

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
        assertEquals(true, solution.isValid("{}"));
        assertEquals(true, solution.isValid("()"));
        assertEquals(true, solution.isValid("()[]{}"));
        assertEquals(false, solution.isValid("(]"));
        assertEquals(false, solution.isValid("([)]"));
        assertEquals(true, solution.isValid("{[]}"));
        assertEquals(false, solution.isValid("[{(]})"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
