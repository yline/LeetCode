package com.test.base;

import java.util.Arrays;

import com.test.SolutionA;
import com.test.SolutionB;

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
        solution = new SolutionA(new int[] {1, 2, 3});
        System.out.println("----------------testSolutionA--------------");
        assertSolution();
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB(new int[] {1, 2, 3});
        System.out.println("--------------testSolutionB----------------");
        assertSolution();
    }
    
    private void assertSolution()
    {
        
        for (int i = 0; i < 6; i++)
        {
            System.out.println(Arrays.toString(solution.shuffle()));
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
