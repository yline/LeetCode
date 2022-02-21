package com.test.base;

import java.util.Arrays;

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
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2, 5, 6};
        solution.merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
