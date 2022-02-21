package com.test.base;

import java.util.Arrays;
import java.util.List;

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
        List<List<Integer>> result = solution.combine(4, 2);
        for (List<Integer> list : result)
        {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
