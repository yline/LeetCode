package com.test.base;

import java.util.Arrays;
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
        List<List<Integer>> resultA = solution.generate(15);
        log(resultA);
    }
    
    private void log(List<List<Integer>> result)
    {
        System.out.println("------------------------------");
        for (int i = 0; i < result.size(); i++)
        {
            System.out.println(Arrays.toString(result.get(i).toArray()));
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
