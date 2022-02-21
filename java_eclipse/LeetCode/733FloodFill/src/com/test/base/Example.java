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
        assertSolution();
    }
    
    private void assertSolution()
    {
        int[][] imageA = {{1,1,1},{1,1,0},{1,0,1}};
        solution.floodFill(imageA, 1, 1, 2);
        ArrayUtils.print(imageA);
        
        int[][] imageB = {{0,0,1},{1,0,0}};
        solution.floodFill(imageB, 1, 0, 2);
        ArrayUtils.print(imageB);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
