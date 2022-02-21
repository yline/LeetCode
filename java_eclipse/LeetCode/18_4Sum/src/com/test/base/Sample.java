package com.test.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.SolutionA;
import com.test.SolutionB;

import junit.framework.TestCase;

public class Sample extends TestCase
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
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertSolution();
    }
    
    private void assertSolution()
    {
        int[] array0 = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result0 = new ArrayList<>();
        result0.add(getList(-2, -1, 1, 2));
        result0.add(getList(-2, 0, 0, 2));
        result0.add(getList(-1, 0, 0, 1));
        
        assertEquals(result0, solution.fourSum(array0, 0));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
    
    public List<Integer> getList(int one, int two, int three, int four)
    {
        return Arrays.asList(one, two, three, four);
    }
}
