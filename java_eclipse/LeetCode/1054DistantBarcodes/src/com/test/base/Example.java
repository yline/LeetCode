package com.test.base;

import org.junit.Assert;

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
        int[] inputA = {1, 1, 1, 2, 2, 2};
        int[] outputA = {1, 2, 1, 2, 1, 2};
        Assert.assertArrayEquals(outputA, solution.rearrangeBarcodes(inputA));
        
        int[] inputB = {1, 1, 1, 1, 2, 2, 3, 3};
        int[] outputB = {1, 2, 1, 2, 1, 3, 1, 3};
        Assert.assertArrayEquals(outputB, solution.rearrangeBarcodes(inputB));
        
        int[] inputC = {7, 7, 7, 8, 5, 7, 5, 5, 5, 8};
        int[] outputC = {7, 8, 7, 5, 7, 5, 7, 5, 8, 5};
        Assert.assertArrayEquals(outputC, solution.rearrangeBarcodes(inputC));
        
        int[] inputD = {1, 2, 3, 4, 4, 4, 4};
        int[] outputD = {7, 8, 7, 5, 7, 5, 7, 5, 8, 5};
        solution.rearrangeBarcodes(inputD);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
