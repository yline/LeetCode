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
        int[][] trustA = {{1, 2}};
        assertEquals(2, solution.findJudge(2, trustA));
        
        int[][] trustB = {{1, 3}, {2, 3}};
        assertEquals(3, solution.findJudge(3, trustB));
        
        int[][] trustC = {{1, 3}, {2, 3}, {3, 1}};
        assertEquals(-1, solution.findJudge(3, trustC));
        
        int[][] trustD = {{1, 2}, {2, 3}};
        assertEquals(-1, solution.findJudge(4, trustD));
        
        int[][] trustE = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        assertEquals(3, solution.findJudge(4, trustE));
        
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
