package com.test.base;

import java.util.Arrays;
import java.util.List;

import com.test.SolutionA;
import com.test.SolutionB;

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
    
    private void assertSolution()
    {
        List<String> resultA = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        isEqual(Arrays.asList("AAAAACCCCC", "CCCCCAAAAA"), resultA);
        
        List<String> resultB = solution.findRepeatedDnaSequences("AAAAAAAAAAAAAAAAAAAA");
        isEqual(Arrays.asList("AAAAAAAAAA"), resultB);
        
        List<String> resultC = solution.findRepeatedDnaSequences("CCCCCCCCCCCCCCCCCCCCCCCCCCC");
        isEqual(Arrays.asList("CCCCCCCCCC"), resultC);
        
        List<String> resultD = solution.findRepeatedDnaSequences("AAAAACCCCC");
        isEqual(Arrays.asList(), resultD);
    }
    
    private void isEqual(List<String> expected, List<String> actual)
    {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++)
        {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
