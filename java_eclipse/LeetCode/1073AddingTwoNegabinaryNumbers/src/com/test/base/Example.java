package com.test.base;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

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
        
        assertSolution(new int[] {0}, new int[] {0}, new int[] {0});
        assertSolution(new int[] {1, 1, 1, 1, 1}, new int[] {1, 0, 1}, new int[] {1, 0, 0, 0, 0});
        assertSolution(new int[] {1}, new int[] {1, 0, 1}, new int[] {1, 1, 0, 1, 0});
    }
    
    private void assertSolution(int[] arr1, int[] arr2, int[] expect)
    {
        int[] actual = solution.addNegabinary(arr1, arr2);
        System.out.println("actual = " + Arrays.toString(actual));
        assertArrayEquals(expect, actual);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
