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
    }
    
    // 递推【动态规划】
    public void testSolutionA()
    {
        solution = new SolutionA();
        assertSolution();
    }
    
    //    // 递归实现
    //    public void testSolutionD()
    //    {
    //        solution = new SolutionD();
    //        assertSolution();
    //    }
    
    private void assertSolution()
    {
        assertEquals(true, solution.isMatch("adadccc", "ad*adc*c"));
        assertEquals(false, solution.isMatch("adadccc", "ad*addcc"));
        
        assertEquals(false, solution.isMatch("aa", "*a")); // 数组越界
        assertEquals(true, solution.isMatch("aa", "*aa"));
        assertEquals(true, solution.isMatch("aab", "*.*"));
        
        assertEquals(true, solution.isMatch("eqwfdasfda", ".*"));
        assertEquals(false, solution.isMatch("dasfewqrddasfd", ".*dd"));
        assertEquals(true, solution.isMatch("erqwdsafd", ".*"));
        assertEquals(true, solution.isMatch("123fda", ".*"));
        assertEquals(true, solution.isMatch("123fda", ".***"));
        assertEquals(false, solution.isMatch("111111111111112", "1***"));
        assertEquals(true, solution.isMatch("111111111111112", "1***.*"));
        assertEquals(true, solution.isMatch("111111111111112", "1*1111111111.*"));
        
        assertEquals(false, solution.isMatch("aa", "a"));
        assertEquals(true, solution.isMatch("aa", "aa"));
        assertEquals(false, solution.isMatch("aaa", "aa"));
        assertEquals(true, solution.isMatch("aa", "a*"));
        assertEquals(true, solution.isMatch("aa", ".*"));
        assertEquals(true, solution.isMatch("ab", ".*"));
        assertEquals(true, solution.isMatch("aab", "aab"));
        assertEquals(true, solution.isMatch("aaaaaaaaaaaaaaaaaccdb", ".*"));
        assertEquals(true, solution.isMatch("aaaaaaaaaaaaaaaaaccdb", "c*a.*db"));
        assertEquals(true, solution.isMatch("aaaaaaaaaaaaaaaaadccdb", "c*aaa.*db"));
        assertEquals(true, solution.isMatch("aa", "aa"));
        
        assertEquals(true, solution.isMatch("aab", "c*a*b"));
        assertEquals(false, solution.isMatch("aa", "aaa"));
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
