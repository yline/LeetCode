package com.test.base;

import java.util.Arrays;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Example extends TestCase
{
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        
        assertSolution();
    }
    
    private void assertSolution()
    {
        SolutionA solution = new SolutionA();
        
        int[] arrA = new int[] {1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(arrA);
        System.out.println(Arrays.toString(arrA));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
