package com.test.base;

import com.test.SolutionA;

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
        
        solution.setRealValue(6);
        assertEquals(6, solution.guessNumber(10));
        
        solution.setRealValue(6);
        assertEquals(6, solution.guessNumber(40));
        
        solution.setRealValue(2);
        assertEquals(2, solution.guessNumber(2));
        
        solution.setRealValue(1702766719);
        assertEquals(1702766719, solution.guessNumber(2126753390));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
