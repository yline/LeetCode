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
        assertEquals(5, solution.removeStones(new int[][] {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        assertEquals(3, solution.removeStones(new int[][] {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));
        assertEquals(0, solution.removeStones(new int[][] {{0, 0}}));
        assertEquals(1, solution.removeStones(new int[][] {{0, 1}, {1, 1}}));
        assertEquals(5, solution.removeStones(new int[][] {{0, 1}, {1, 2}, {1, 3}, {3, 3}, {2, 3}, {0, 2}}));
        assertEquals(4, solution.removeStones(new int[][] {{3, 2}, {3, 1}, {4, 4}, {1, 1}, {0, 2}, {4, 0}}));
        
        // A方案，该处 失败
        assertEquals(6, solution.removeStones(new int[][] {{3, 2}, {0, 0}, {3, 3}, {2, 1}, {2, 3}, {2, 2}, {0, 2}}));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
