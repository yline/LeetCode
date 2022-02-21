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
        assertEquals(3, solution.hammingWeight(11));
        assertEquals(1, solution.hammingWeight(1));
        assertEquals(1, solution.hammingWeight(2));
        assertEquals(1, solution.hammingWeight(4));
        assertEquals(1, solution.hammingWeight(8));
        assertEquals(1, solution.hammingWeight(16));
        assertEquals(1, solution.hammingWeight(32));
        assertEquals(1, solution.hammingWeight(64));
        assertEquals(1, solution.hammingWeight(128));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
