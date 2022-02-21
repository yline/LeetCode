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
        assertSolution();
    }
    
    public void testSolutionB()
    {
        solution = new SolutionB();
        assertSolution();
    }
    
    private void assertSolution()
    {
        int[] numC = {-3, -4};
        int resultC = solution.maxProduct(numC);
        assertEquals(resultC, 12);
        System.out.println("resultC = " + resultC);
        
        int[] numA = {2, 3, -2, 4};
        int resultA = solution.maxProduct(numA);
        assertEquals(resultA, 6);
        System.out.println("resultA = " + resultA);
        
        int[] numB = {-2, 0, -1};
        int resultB = solution.maxProduct(numB);
        assertEquals(resultB, 0);
        System.out.println("resultB = " + resultB);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
