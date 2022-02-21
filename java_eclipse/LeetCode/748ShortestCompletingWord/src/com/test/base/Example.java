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
        String[] wordsA = new String[] {"step", "steps", "stripe", "stepple"};
        assertEquals("steps", solution.shortestCompletingWord("1s3 PSt", wordsA));
        
        String[] wordsB = new String[] {"looks", "pest", "stew", "show"};
        assertEquals("pest", solution.shortestCompletingWord("1s3 456", wordsB));
        
        String[] wordsC = new String[] {"enough","these","play","wide","wonder","box","arrive","money","tax","thus"};
        assertEquals("enough", solution.shortestCompletingWord("OgEu755", wordsC));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
