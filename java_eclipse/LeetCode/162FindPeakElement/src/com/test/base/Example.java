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
        System.out.println("-------SolutionA-------");
        solution = new SolutionA();
        assertSolution();
    }
    
    public void testSolutionB()
    {
        System.out.println("-------SolutionB-------");
        solution = new SolutionB();
        assertSolution();
    }
    
    private void assertSolution()
    {
        int result1 = solution.findPeakElement(new int[] {1, 2, 3, 1});
        System.out.println(result1);
        assertTrue(result1 == 2);
        
        int result2 = solution.findPeakElement(new int[] {1, 2, 1, 3, 5, 6, 4});
        System.out.println(result2);
        assertTrue(result2 == 1 || result2 == 5);
        
        System.out.println("");
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
