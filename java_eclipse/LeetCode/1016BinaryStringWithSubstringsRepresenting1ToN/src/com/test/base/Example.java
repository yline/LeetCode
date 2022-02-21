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
        // 检测工具类
        assertEquals(2, solution.getFirstValue("101010", 2));
        assertEquals(3, solution.getFirstValue("101011", 2));
        assertEquals(1, solution.getFirstValue("101001", 2));
        assertEquals(1, solution.getFirstValue("101001", 3));
        assertEquals(5, solution.getFirstValue("1010101", 3));
        
        // 检测结果值
        assertEquals(true, solution.queryString("0110", 3));
        assertEquals(false, solution.queryString("0110", 4));
        
        assertEquals(true, solution.queryString("1111000101", 5));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
