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
        System.out.println("------------------------------------");
        assertEquals(2, solution.removeInvalidParentheses("()())()").size());
        assertEquals(2, solution.removeInvalidParentheses("(a)())()").size());
        
        // 大小居然是1，很奇怪
        List<String> resultC = solution.removeInvalidParentheses(")(");
        System.out.println(Arrays.toString(resultC.toArray()));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
}
