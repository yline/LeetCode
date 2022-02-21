package com.test.base;

import com.test.SolutionA;
import com.test.SolutionB;
import com.test.SolutionC;
import com.test.SolutionD;
import com.test.SolutionE;

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
    
    public void testSolutionC()
    {
        solution = new SolutionC();
        assertSolution();
    }
    
    public void testSolutionD()
    {
        solution = new SolutionD();
        assertSolution();
    }
    
    public void testSolutionE()
    {
        solution = new SolutionE();
        assertSolution();
    }
    
    private void assertSolution()
    {
        assertEquals("ana", solution.longestDupSubstring("banana"));
        assertEquals("abc", solution.longestDupSubstring("abcabxabyabcd"));
        assertEquals("aaaaaa", solution.longestDupSubstring("aaaaaaa"));
        
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 10000; i++)
        {
            sBuilder.append('a');
        }
        String s9999 = sBuilder.toString();
        assertEquals(s9999.substring(0, 9999), solution.longestDupSubstring(s9999));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
