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
        checkSolution("https://www.example.com/art");
        checkSolution("https://leetcode.com/problems/design-tinyurl");
        checkSolution("https://bone.example.net/?brother=agreement&beds=bird");
        checkSolution("https://agreement.example.com/");
    }
    
    private void checkSolution(String longUrl) {
    	System.out.println("----------------------------------");
    	String shortUrl = solution.encode(longUrl);
    	System.out.println("short = " + shortUrl);
    	
    	String result = solution.decode(shortUrl);
    	System.out.println("result = " + result);
    	assertEquals(result, longUrl);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
