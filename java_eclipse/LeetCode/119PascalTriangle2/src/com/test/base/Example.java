package com.test.base;

import java.util.Arrays;

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
        assertEquals("[1]", Arrays.toString(solution.getRow(0).toArray()));
        assertEquals("[1, 1]", Arrays.toString(solution.getRow(1).toArray()));
        assertEquals("[1, 2, 1]", Arrays.toString(solution.getRow(2).toArray()));
        assertEquals("[1, 3, 3, 1]", Arrays.toString(solution.getRow(3).toArray()));
        assertEquals("[1, 4, 6, 4, 1]", Arrays.toString(solution.getRow(4).toArray()));
        assertEquals("[1, 5, 10, 10, 5, 1]", Arrays.toString(solution.getRow(5).toArray()));
        assertEquals("[1, 6, 15, 20, 15, 6, 1]", Arrays.toString(solution.getRow(6).toArray()));
        assertEquals("[1, 7, 21, 35, 35, 21, 7, 1]", Arrays.toString(solution.getRow(7).toArray()));
        assertEquals("[1, 8, 28, 56, 70, 56, 28, 8, 1]", Arrays.toString(solution.getRow(8).toArray()));
        assertEquals("[1, 9, 36, 84, 126, 126, 84, 36, 9, 1]", Arrays.toString(solution.getRow(9).toArray()));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
