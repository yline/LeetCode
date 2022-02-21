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
        int[] arrayA = {1, 2, 1, 3, 2, 5};
        ArrayUtils.assertArrayEqualsWithoutOrder(new int[] {3, 5}, solution.singleNumber(arrayA));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
