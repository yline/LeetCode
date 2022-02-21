package com.test.base;

import com.test.BrowserHistory;

import junit.framework.TestCase;

public class Example extends TestCase
{
    private BrowserHistory solution;
    
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }
    
    public void testSolutionA()
    {
        
        assertSolution();
    }
    
    private void assertSolution()
    {
    	/**
"BrowserHistory",	// ["leetcode.com"],		null
"visit",			// ["google.com"],			null
"visit",			// ["facebook.com"],		null
"visit",			// ["youtube.com"],			null

"back",				// [1],						"facebook.com"
"back",				// [1],						"google.com"
"forward",			// [1],						"facebook.com"
"visit",			// ["linkedin.com"],		null
"forward",			// [2],						"linkedin.com"
"back",				// [2],						"google.com"
"back"]				// [7]						"leetcode.com"
    	 */
    	solution = new BrowserHistory("leetcode.com");
    	solution.visit("google.com");
    	solution.visit("facebook.com");
    	solution.visit("youtube.com");
    	
    	System.out.println(solution.back(1));
    	System.out.println(solution.back(1));
    	
    	System.out.println(solution.forward(1));
    	solution.visit("linkedin.com");
    	
    	System.out.println(solution.forward(2));
    	System.out.println(solution.back(2));
    	System.out.println(solution.back(7));
    	
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
