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
        
        assertEquals(1, solution.maxEqualRowsAfterFlips(new int[][] {{0, 1}, {1, 1}}));
        assertEquals(2, solution.maxEqualRowsAfterFlips(new int[][] {{0, 1}, {1, 0}}));
        assertEquals(2, solution.maxEqualRowsAfterFlips(new int[][] {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}}));
        
        assertEquals(10,
            solution.maxEqualRowsAfterFlips(new int[][] {{0}, {1}, {0}, {0}, {1}, {1}, {1}, {1}, {0}, {1}}));
        
        assertEquals(10,
            solution.maxEqualRowsAfterFlips(new int[][] {{0, 0, 1, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {0, 1, 1, 0},
                {0, 0, 1, 0}, {0, 0, 1, 1}, {0, 0, 1, 0}, {1, 0, 1, 1}, {0, 1, 0, 0}, {0, 1, 0, 0}, {1, 1, 1, 1},
                {0, 1, 0, 0}, {1, 1, 0, 0}, {0, 1, 1, 1}, {0, 0, 0, 0}, {1, 0, 1, 1}, {1, 1, 0, 1}, {1, 0, 0, 0},
                {0, 1, 0, 1}, {0, 1, 0, 0}, {1, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 1}, {0, 0, 0, 0},
                {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}}));
        
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
