package com.test.base;

import com.test.SolutionA;

import junit.framework.TestCase;

public class Sample extends TestCase
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
        String[] str = new String[] {"leet1", "leet2", "le2et3", "leet4"};
        String result = solution.longestCommonPrefix(str);
        System.out.println("result = " + result);
        
        String[] str2 = new String[] {"", "", ""};
        String result2 = solution.longestCommonPrefix(str2);
        System.out.println("result2 = " + result2);
        
        String[] str3 = new String[] {"aca", "cba"};
        String result3 = solution.longestCommonPrefix(str3);
        System.out.println("result3 = " + result3);
    }
    
    @Override
    protected void tearDown()
        throws Exception
    {
        solution = null;
        super.tearDown();
    }
}
