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
        List<Integer> resultA = solution.grayCode(0);
        System.out.println(Arrays.toString(resultA.toArray()));
        
        List<Integer> resultB = solution.grayCode(1);
        System.out.println(Arrays.toString(resultB.toArray()));
        
        List<Integer> resultC = solution.grayCode(2);
        System.out.println(Arrays.toString(resultC.toArray()));
        
        List<Integer> resultD = solution.grayCode(3);
        System.out.println(Arrays.toString(resultD.toArray()));
        
        List<Integer> resultE = solution.grayCode(4);
        System.out.println(Arrays.toString(resultE.toArray()));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
