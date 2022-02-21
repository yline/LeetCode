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
        assertEquals("/home", solution.simplifyPath("/home/"));
        assertEquals("/", solution.simplifyPath("/../"));
        assertEquals("/home/foo", solution.simplifyPath("/home//foo/"));
        assertEquals("/c", solution.simplifyPath("/a/./b/../../c/"));
        assertEquals("/c", solution.simplifyPath("/a/../../b/../c//.//"));
        assertEquals("/a/b/c", solution.simplifyPath("/a//b////c/d//././/.."));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
