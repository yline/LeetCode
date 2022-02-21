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
        
        assertEquals("ABC", solution.gcdOfStrings("ABCABC", "ABC"));
        assertEquals("ABAB", solution.gcdOfStrings("ABAB", "ABAB"));
        assertEquals("", solution.gcdOfStrings("LEFT", "CODE"));
        
        assertEquals("TAUXX",
            solution.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
        
        assertEquals("CXTXN",
            solution.gcdOfStrings("CXTXNCXTXNCXTXNCXTXNCXTXN",
                "CXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXN"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
