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
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        int[] array2 = {4, 5, 6, 7, 8, 1, 2, 3};
        int[] array3 = {8, 1};
        int[] array4 = {1, 3};
        
        // 先测试，二分法是否正确
        assertEquals(4, solution.binarySearchIndex(array));
        assertEquals(5, solution.binarySearchIndex(array2));
        assertEquals(1, solution.binarySearchIndex(array3));
        assertEquals(0, solution.binarySearchIndex(array4));
        
        // 测试目标
        assertEquals(4, solution.search(array, 0));
        assertEquals(-1, solution.search(array, 3));
        assertEquals(-1, solution.search(array3, 0));
        assertEquals(0, solution.search(array4, 1));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
