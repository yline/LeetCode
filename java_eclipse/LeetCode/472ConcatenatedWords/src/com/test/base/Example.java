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
        solution.findAllConcatenatedWordsInADict(new String[] {"cat", "cats", "catsdogcats", "dog", "dogcatsdog",
            "hippopotamuses", "rat", "ratcatdogcat"});
        // 输出 ["catsdogcats","dogcatsdog","ratcatdogcat"]
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
