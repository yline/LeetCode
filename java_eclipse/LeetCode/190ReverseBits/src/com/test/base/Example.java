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
        solution = new SolutionA();
    }
    
    /**
     * 这个测试用例很不好写，那边测试的时候，数组很明显越界了
     */
    public void testSolution()
    {
        assertEquals(0, solution.reverseBits(0));
        assertEquals(964176192, solution.reverseBits(43261596));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
