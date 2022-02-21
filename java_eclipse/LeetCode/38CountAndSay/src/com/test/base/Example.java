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
        //        
        //        assertEquals("1", solution.countAndSay(1));
        //        assertEquals("11", solution.countAndSay(2));
        //        assertEquals("21", solution.countAndSay(3));
        //        assertEquals("1211", solution.countAndSay(4));
        //        assertEquals("111221", solution.countAndSay(5));
        solution.countAndSay(30);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
