package com.test.base;

import com.test.SolutionA;
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
    
    public void testSolutionC()
    {
        solution = new SolutionC();
        assertSolution();
    }
    
    private void assertSolution()
    {
        int[][] graphA = {{1, 2, 3}, {0}, {0}, {0}};
        assertEquals(4, solution.shortestPathLength(graphA));
        
        int[][] graphB = {{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}};
        assertEquals(4, solution.shortestPathLength(graphB));
        
        int[][] graphC = {{1}, {0, 2, 4}, {1, 3}, {2}, {1, 5}, {4}};
        assertEquals(6, solution.shortestPathLength(graphC));
        
        int[][] graphD = {{2, 3}, {7}, {0, 6}, {0, 4, 7}, {3, 8}, {7}, {2}, {5, 3, 1}, {4}};
        assertEquals(11, solution.shortestPathLength(graphD));
        
        int[][] graphE = {{2, 3, 5, 7}, {2, 3, 7}, {0, 1}, {0, 1}, {7}, {0}, {10},
            {9, 10, 0, 1, 4}, {9}, {7, 8}, {7, 6}};
        assertEquals(14, solution.shortestPathLength(graphE));
        
        int[][] graphF = {{}};
        assertEquals(0, solution.shortestPathLength(graphF));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
