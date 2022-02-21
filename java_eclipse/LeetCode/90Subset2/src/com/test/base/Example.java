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
        List<List<Integer>> resultA = solution.subsetsWithDup(new int[] {1, 2, 2});
        print(resultA);
    }
    
    private void print(List<List<Integer>> result)
    {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append('[');
        sBuilder.append('\n');
        for (List<Integer> list : result)
        {
            sBuilder.append(Arrays.toString(list.toArray()));
            sBuilder.append('\n');
        }
        sBuilder.append(']');
        
        System.out.println(sBuilder.toString());
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
