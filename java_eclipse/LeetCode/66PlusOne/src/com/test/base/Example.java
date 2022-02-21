package com.test.base;

import static org.junit.Assert.assertArrayEquals;

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
        assertArrayEquals(new int[] {1, 2, 4}, solution.plusOne(new int[] {1, 2, 3}));
        assertArrayEquals(new int[] {4, 3, 2, 2}, solution.plusOne(new int[] {4, 3, 2, 1}));
        assertArrayEquals(new int[] {1, 0, 0, 0}, solution.plusOne(new int[] {9, 9, 9}));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
