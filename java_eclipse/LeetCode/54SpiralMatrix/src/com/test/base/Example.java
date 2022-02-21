package com.test.base;

import java.util.List;

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
        List<Integer> resultA = solution.spiralOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        assertSolution(resultA, new int[] {1, 2, 3, 6, 9, 8, 7, 4, 5});
    }
    
    private void assertSolution(List<Integer> result, int[] expect)
    {
        assertEquals(result.size(), expect.length);
        
        for (int i = 0; i < result.size(); i++)
        {
            assertEquals(expect[i], result.get(i).intValue());
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
