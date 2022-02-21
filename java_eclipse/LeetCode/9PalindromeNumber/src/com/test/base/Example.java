package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

/**
 * 严重怀疑正确answer
 */
public class Example extends TestCase
{
    private Solution solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
        solution = new SolutionA();
    }
    
    public void testSolution()
    {
        assertEquals(true, solution.isPalindrome(0));
        assertEquals(true, solution.isPalindrome(13231));
        assertEquals(false, solution.isPalindrome(334));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
