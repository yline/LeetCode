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
        assertEquals(1, solution.minCut("aab"));
        assertEquals(1, solution.minCut("aaab"));
        assertEquals(1, solution.minCut("aaaab"));
        assertEquals(1, solution.minCut("aaaaab"));
        assertEquals(1, solution.minCut("aaaaaabbbbbbb"));
        
        assertEquals(1, solution.minCut("abb"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
