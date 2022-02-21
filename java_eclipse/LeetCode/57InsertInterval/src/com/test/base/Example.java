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
        SolutionA.testMethod();
        
        int[][] intervalsA = new int[][] {{1, 2}, {3, 6}, {8, 10}, {15, 18}};
        solution.insert(intervalsA, new int[] {-1, 0}); // -1 0
        solution.insert(intervalsA, new int[] {-1, 1}); // -1 1
        solution.insert(intervalsA, new int[] {-1, 2}); // -1 1
        solution.insert(intervalsA, new int[] {-1, 3}); // -1 2
        solution.insert(intervalsA, new int[] {-1, 19}); // -1 4
        
        int[][] intervalsB = new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        solution.insert(intervalsB, new int[] {4, 8});
        
        /*
        int[][] intervalsB = new int[][] {{1, 4}, {2, 3}};
        solution.insert(intervalsB, new int[] {});*/
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
