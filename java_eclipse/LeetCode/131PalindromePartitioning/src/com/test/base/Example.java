package com.test.base;

import java.util.List;

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
        List<List<String>> resultA = solution.partition("aab");
        ListUtils.print(resultA);
        
        List<List<String>> resultB = solution.partition("aaab");
        ListUtils.print(resultB);
        
        List<List<String>> resultC = solution.partition("cbbbcc");
        ListUtils.print(resultC);
        
        /*List<List<String>> resultC = solution.partition("aaabbbbccccddd");
        ListUtils.print(resultC);*/
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
