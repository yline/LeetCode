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
    
    public void testSolution()
    {
        assertEquals("", solution.convert("", 1));
        assertEquals("", solution.convert("", 2));
        assertEquals("", solution.convert("", 3));
        
        assertEquals("ABCDEFGHIJKLMN", solution.convert("ABCDEFGHIJKLMN", 1));
        assertEquals("ACEGIKMBDFHJLN", solution.convert("ABCDEFGHIJKLMN", 2));
        assertEquals("AEIMBDFHJLNCGK", solution.convert("ABCDEFGHIJKLMN", 3));
        assertEquals("AGMBFHLNCEIKDJ", solution.convert("ABCDEFGHIJKLMN", 4));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
