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
        solution = new SolutionA();
    }
    
    public void testSolution()
    {
        int[] arrayA = {};
        equal(new int[] {-1, -1}, solution.searchRange(arrayA, 1));
        
        int[] arrayB = {1};
        equal(new int[] {-1, -1}, solution.searchRange(arrayB, 0));
        equal(new int[] {0, 0}, solution.searchRange(arrayB, 1));
        
        int[] arrayC = {1, 2, 2, 2, 2, 3, 4};
        equal(new int[] {1, 4}, solution.searchRange(arrayC, 2));
        
        int[] arrayD = {1, 1, 2};
        equal(new int[] {0, 1}, solution.searchRange(arrayD, 1));
    }
    
    public void equal(int[] expected, int[] result)
    {
        assertEquals(expected[0], result[0]);
        assertEquals(expected[1], result[1]);
    }
    
    public void testSearchLeft()
    {
        int[] arrayA = {1};
        assertEquals(0, solution.searchMidLeftIndex(arrayA, 1, 0));
        
        int[] arrayB = {1, 2};
        assertEquals(1, solution.searchMidLeftIndex(arrayB, 2, 1));
        
        int[] arrayC = {1, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        assertEquals(1, solution.searchMidLeftIndex(arrayC, 2, 4));
        assertEquals(1, solution.searchMidLeftIndex(arrayC, 2, 5));
        assertEquals(1, solution.searchMidLeftIndex(arrayC, 2, 6));
    }
    
    public void testSearchRight()
    {
        int[] arrayA = {1};
        assertEquals(0, solution.searchMidRightIndex(arrayA, 1, 0));
        
        int[] arrayB = {1, 2};
        assertEquals(0, solution.searchMidRightIndex(arrayB, 1, 0));
        
        int[] arrayC = {2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        assertEquals(8, solution.searchMidRightIndex(arrayC, 2, 1));
        assertEquals(8, solution.searchMidRightIndex(arrayC, 2, 2));
        assertEquals(8, solution.searchMidRightIndex(arrayC, 2, 3));
        assertEquals(8, solution.searchMidRightIndex(arrayC, 2, 4));
        
        int[] arrayD = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        assertEquals(9, solution.searchMidRightIndex(arrayD, 2, 1));
        
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
