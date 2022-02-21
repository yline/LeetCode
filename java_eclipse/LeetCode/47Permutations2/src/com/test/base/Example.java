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
        // A
        System.out.println("--------------A-------------");
        int[] arrayA = {1, 2, 3};
        List<List<Integer>> resultA = solution.permuteUnique(arrayA);
        log(resultA);
        
        // B
        System.out.println("--------------B-------------");
        int[] arrayB = {1, 1, 2, 2};
        List<List<Integer>> resultB = solution.permuteUnique(arrayB);
        log(resultB);
    }
    
    private void log(List<List<Integer>> result)
    {
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
