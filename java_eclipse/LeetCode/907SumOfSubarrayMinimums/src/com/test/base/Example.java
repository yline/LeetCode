package com.test.base;

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
        solution = new SolutionA();
        solution.sumSubarrayMins(new int[] {3, 1, 2, 4});
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        solution.sumSubarrayMins(new int[] {3, 1, 2, 4});
    }
    

    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
