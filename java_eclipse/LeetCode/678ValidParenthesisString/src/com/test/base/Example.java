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
        assertEquals(true, solution.checkValidString("()"));
        assertEquals(true, solution.checkValidString("(*)"));
        assertEquals(true, solution.checkValidString("(*))"));
        assertEquals(false, solution.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        assertEquals(true, solution.checkValidString("((()))()(())(*()()())**(())()()()()((*()*))((*()*)"));
        assertEquals(false, solution.checkValidString("(())(())(((()*()()()))()((()()(*()())))(((*)()"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
