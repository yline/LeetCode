package com.test.base;

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
        assertSolution();
    }
    
    private void assertSolution()
    {
        int[] numA = new int[] {1, 1, 1, 2, 2, 3};
        assertEquals(5, solution.removeDuplicates(numA));
        System.out.println(Arrays.toString(numA));
        
        int[] numB = new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3};
        assertEquals(7, solution.removeDuplicates(numB));
        System.out.println(Arrays.toString(numB));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
