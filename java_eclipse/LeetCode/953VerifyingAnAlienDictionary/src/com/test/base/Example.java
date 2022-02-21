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
        String[] wordsA = {"hello", "leetcode"};
        assertEquals(true, solution.isAlienSorted(wordsA, "hlabcdefgijkmnopqrstuvwxyz"));
        
        String[] wordsB = {"word", "world", "row"};
        assertEquals(false, solution.isAlienSorted(wordsB, "worldabcefghijkmnpqstuvxyz"));
        
        String[] wordsC = {"apple", "app"};
        assertEquals(false, solution.isAlienSorted(wordsC, "abcdefghijklmnopqrstuvwxyz"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
