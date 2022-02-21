package com.test.base;

import java.util.Arrays;

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
        assertEquals(true, solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
        assertEquals(true, solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        assertEquals(false, solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        
        assertEquals(true, solution.wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd")));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
