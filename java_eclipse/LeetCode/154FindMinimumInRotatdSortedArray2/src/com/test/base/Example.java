package com.test.base;

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
        int[] num1 = {2, 2, 2, 0, 1};
        int result1 = solution.findMin(num1);
        System.out.println("result1 = " + result1);
        
        int[] num2 = {1, 3, 5};
        int result2 = solution.findMin(num2);
        System.out.println("result2 = " + result2);
        
        int[] num3 = {1, 1, 3};
        int result3 = solution.findMin(num3);
        System.out.println("result3 = " + result3);
        
        int[] numsA = {4, 5, 6, 7, 0, 1, 2};
        int resultA = solution.findMin(numsA);
        System.out.println("resultA = " + resultA);
        assertEquals(0, resultA);
        
        int[] numsB = {3, 4, 5, 1, 2};
        int resultB = solution.findMin(numsB);
        System.out.println("resultB = " + resultB);
        assertEquals(1, resultB);
        
        int[] numsC = {7, 0};
        int resultC = solution.findMin(numsC);
        System.out.println("resultC = " + resultC);
        assertEquals(0, resultC);
        
        int[] numsD = {7, 0, 1};
        int resultD = solution.findMin(numsD);
        System.out.println("resultD = " + resultD);
        assertEquals(0, resultD);
        
        int[] numsE = {4, 5, 1, 2, 3};
        int resultE = solution.findMin(numsE);
        System.out.println("resultE = " + resultE);
        assertEquals(1, resultE);
        
        int[] numsG = {1};
        int resultG = solution.findMin(numsG);
        System.out.println("resultG = " + resultG);
        assertEquals(1, resultB);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
